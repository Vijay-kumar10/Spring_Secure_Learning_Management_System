package com.lms.controller;

import com.lms.dao.UserDao;
import com.lms.dto.CommonApiResponse;
import com.lms.entity.User;
import com.lms.service.EmailService;
import com.lms.service.MailContentService;
import com.lms.utility.Constants;
import jakarta.servlet.http.HttpServletResponse; // Required import for redirect
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class VerificationController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private EmailService emailService;

    @GetMapping("/emailVerification")
    private void verifyEmail(@RequestParam("token") String token, HttpServletResponse response) throws IOException {
        System.out.println("User verified Successfully using email verification");

        // CommonApiResponse removed as we're handling redirect directly
        User user = userDao.findByEmailToken(token).orElse(null);
        System.out.println(user);

        if(user != null){
            if(user.getEmailToken().equals(token)){
                user.setStatus(Constants.ActiveStatus.ACTIVE.value());
                user.setEmailVerified("Verified");
                userDao.save(user);

                // Send email after successful verification
                String mail_content = MailContentService.getVerifySuccessfullMail();
                emailService.sendEmail(user.getEmailId(), "Welcome to LMS - Your Registration is Complete", mail_content);

                // Redirecting to login page after successful verification
                response.sendRedirect("https://learning-management-system-olive.vercel.app/user/login");
                return; // Stop further execution after redirect
            }
        }

        // Redirect in case of error (invalid token or user not found)
        response.sendRedirect("https://learning-management-system-olive.vercel.app/user/login?error=invalid-token");
    }
}
