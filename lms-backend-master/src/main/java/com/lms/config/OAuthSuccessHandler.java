package com.lms.config;

import com.lms.dto.UserDto;
import com.lms.dto.UserLoginRequest;
import com.lms.dto.UserLoginResponse;
import com.lms.entity.User;
import com.lms.service.UserService;
import com.lms.utility.Constants;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.logging.Logger;

@Component
public class OAuthSuccessHandler implements AuthenticationSuccessHandler {

    Logger logger = Logger.getLogger(OAuthSuccessHandler.class.getName());

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate; // ✅ Injected

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        HttpSession session = request.getSession();

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        var oAuth2Token = (OAuth2AuthenticationToken) authentication;
        var oAuthuser = (DefaultOAuth2User) authentication.getPrincipal();

        String authorizeClientID = oAuth2Token.getAuthorizedClientRegistrationId();
        String email = "";

        User user = new User();
        user.setAmount(BigDecimal.ZERO);
        user.setStatus(Constants.ActiveStatus.ACTIVE.value());
        user.setRole(Constants.UserRole.ROLE_STUDENT.value());
        user.setPassword(encoder.encode("123"));
        user.setPhoneNo("1020304050");

        if (authorizeClientID.equalsIgnoreCase("google")) {
            email = oAuthuser.getAttribute("email").toString();
            user.setEmailId(email);
            user.setFirstName(oAuthuser.getAttribute("name").toString());
        } else if (authorizeClientID.equalsIgnoreCase("github")) {
            email = oAuthuser.getAttribute("email") != null ?
                    oAuthuser.getAttribute("email").toString() :
                    oAuthuser.getAttribute("login").toString() + "@github.com";
            user.setEmailId(email);
            user.setFirstName(oAuthuser.getAttribute("login").toString());
        }

        // ✅ Check if user already exists
        User existingUser = userService.getUserByEmailid(email);
        if (existingUser == null) {
            userService.addUser(user);
        } else {
            user = existingUser;
        }

        // ✅ Prepare login request
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmailId(email);
        userLoginRequest.setPassword("123");
        userLoginRequest.setRole(Constants.UserRole.ROLE_STUDENT.value());

        // ✅ Call login API internally
        ResponseEntity<UserLoginResponse> loginResponse = restTemplate.postForEntity(
                "https://lmsbackend-production-3f74.up.railway.app/api/user/login",
                userLoginRequest,
                UserLoginResponse.class
        );

        // ✅ Extract JWT token and user data
        String token = loginResponse.getBody().getJwtToken();
        UserDto responseUser = loginResponse.getBody().getUser();
        String userRole = responseUser.getRole(); // or any other user data you want to send

        logger.info("JWT Token: " + token);
        session.setAttribute("user", responseUser);

        // ✅ Redirect to frontend with token and user data (email and role)
        String redirectUrl = "https://learning-management-system-olive.vercel.app/home?token=" + token + "&email=" + email + "&role=" + userRole;
        new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }
}
