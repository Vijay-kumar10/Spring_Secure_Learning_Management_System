package com.lms.controller;

import com.lms.entity.User;
import com.lms.helper.EmailLinkHelper;
import com.lms.service.EmailService;
import com.lms.service.MailContentService;
import com.lms.service.OtpService;
import com.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lms.dto.AddMentorDetailRequestDto;
import com.lms.dto.CommonApiResponse;
import com.lms.dto.RegisterUserRequestDto;
import com.lms.dto.UserLoginRequest;
import com.lms.dto.UserLoginResponse;
import com.lms.dto.UserResponseDto;
import com.lms.resource.UserResource;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "https://learning-management-system-olive.vercel.app")
public class UserController {

	@Autowired
	private UserResource userResource;

    @Autowired
    private UserService userService;

	@Autowired
	private OtpService otpService;

	@Autowired
	private EmailService emailService;

	public static String loginOtp;

	// RegisterUserRequestDto, we will set only email, password & role from UI
	@PostMapping("/admin/register")
	@Operation(summary = "Api to register Admin")
	private ResponseEntity<CommonApiResponse> registerAdmin(@RequestBody RegisterUserRequestDto request) {
		return userResource.registerAdmin(request);
	}

	// for customer and tour guide register
	@PostMapping("register")
	@Operation(summary = "Api to register customer or seller user")
	public ResponseEntity<CommonApiResponse> registerUser(@RequestBody RegisterUserRequestDto request) {
		return this.userResource.registerUser(request);
	}

	@PutMapping("mentor/detail/update")
	@Operation(summary = "Api to update the mentor detail")
	public ResponseEntity<CommonApiResponse> addMentorDetail(AddMentorDetailRequestDto request) {
		return this.userResource.addMentorDetail(request);
	}

	@PostMapping("/sendOtp")
	public ResponseEntity<UserLoginResponse> requestToSendOtp(@RequestBody UserLoginRequest userLoginRequest){

        // Create a failed UserLoginResponse
        UserLoginResponse response = new UserLoginResponse();
		User user = this.userService.getUserByEmailid(userLoginRequest.getEmailId());
		if (user == null || user.getEmailId() == null) {
			System.out.println("User not found or email is null");
			response.setResponseMessage("User Not Registered!!!");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

//		 🔐 Check if account is locked
		if (user.getAccountLockedUntil() != null && user.getAccountLockedUntil().isAfter(LocalDateTime.now())) {
			response.setResponseMessage("Account locked until " + user.getAccountLockedUntil().toString());
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		//check if the user is verified on not !!
		if (user.getEmailVerified().equals("not_Verified")) {
			response.setResponseMessage("User Not Verified!!!");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}


		System.out.println("***********Send OTP Request is occurred**********");
		String emailId = userLoginRequest.getEmailId();
		System.out.println("******email id received: " + emailId);
		loginOtp = otpService.otpGenerator();
		System.out.println("***********OTP generated successfully : **********" + loginOtp);
		String mail_Content = MailContentService.getOtpMail(loginOtp);
		emailService.sendEmail(emailId, "Your OTP to Access Your LMS Account", mail_Content);


		response.setSuccess(true);
		response.setResponseMessage("Otp Sent Successfully to your email");
		return ResponseEntity.ok(response);
	}


	@PostMapping("login")
	@Operation(summary = "Api to login any User")
	public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
		System.out.println("***********Login Request is occurred**********");
		System.out.println("***********Current otp is : **********  : " + loginOtp);
		System.out.println(userLoginRequest);

		if (userLoginRequest.getOtp().equals(loginOtp)) {
			System.out.println("***********OTP verified successfully : **********" + loginOtp);
			return userResource.login(userLoginRequest);
		}

		// Create a failed UserLoginResponse
		UserLoginResponse errorResponse = new UserLoginResponse();
		errorResponse.setSuccess(false);
		errorResponse.setResponseMessage("Invalid OTP");
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//		return userResource.login(userLoginRequest);
	}


	@GetMapping("/fetch/role-wise")
	@Operation(summary = "Api to get Users By Role")
	public ResponseEntity<UserResponseDto> fetchAllUsersByRole(@RequestParam("role") String role)
			throws JsonProcessingException {
		return userResource.getUsersByRole(role);
	}

	@DeleteMapping("/mentor/delete")
	@Operation(summary = "Api to delete the mentor and all it's course")
	public ResponseEntity<CommonApiResponse> deleteMentor(@RequestParam("mentorId") Integer mentorId) {
		return userResource.deleteMentor(mentorId);
	}

	@GetMapping("/fetch/user-id")
	@Operation(summary = "Api to get User Detail By User Id")
	public ResponseEntity<UserResponseDto> fetchUserById(@RequestParam("userId") int userId) {
		return userResource.getUserById(userId);
	}


	
	@GetMapping(value = "/{userImageName}", produces = "image/*")
	public void fetchTourImage(@PathVariable("userImageName") String userImageName, HttpServletResponse resp) {
		this.userResource.fetchUserImage(userImageName, resp);
	}

}
