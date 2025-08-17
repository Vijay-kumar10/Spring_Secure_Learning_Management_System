package com.lms.service;

import org.springframework.stereotype.Service;

public class MailContentService {

    //function for opt mail content
    public static String getOtpMail(String otp) {
        String otp_mail = "Dear User,\n" +
                "\n" +
                "Your OTP: "+otp+"\n" +
                "We have received a request to log in to your account on our Learning Management System (LMS).\n" +
                "\n" +
                "To proceed, please use the One-Time Password (OTP) provided.\n" +
                "\n" +
                "This OTP is valid for a limited time and can only be used once. Do not share this code with anyone for your account's security.\n" +
                "\n" +
                "If you did not request this login, please ignore this email or contact our support team immediately.\n" +
                "\n" +
                "Thank you,  \n" +
                "LMS Support Team\n";
        return  otp_mail;
    }

    //account susspend mail
    public static String getAccountSuspensionMail() {
        String suspension_mail = "Subject: Account Temporarily Suspended Due to Multiple Failed Login Attempts\n\n" +
                "Dear User,\n\n" +
                "Your account has been temporarily suspended for 15 minutes due to multiple failed login attempts.\n\n" +
                "We detected more than 3 consecutive login attempts with incorrect credentials.\n" +
                "As a security measure to protect your account, access has been restricted temporarily.\n\n" +
                "Please wait 15 minutes before trying to log in again.\n" +
                "If you believe this was a mistake or need immediate assistance, please contact our support team.\n\n" +
                "Thank you,\n" +
                "LMS Support Team\n";
        return suspension_mail;
    }

    //function for login mail content
    public static String getLoginMail() {
        String login_Mail = "Dear User,\n" +
                "\n" +
                "This is to inform you that a successful login was made to your Learning Management System (LMS) account.\n" +
                "\n" +
                "If you recognize this activity, no further action is required.\n" +
                "\n" +
                "However, if this was not you, we strongly recommend that you secure your account immediately by resetting your password and contacting our support team.\n" +
                "\n" +
                "We care about your account’s security and are here to help if needed.\n" +
                "\n" +
                "Best regards,  \n" +
                "LMS Security Team\n";
        return  login_Mail;
    }

    //function for opt mail content
    public static String getVerifyMail(String link) {
        String verify_Mail = "Dear User,\n" +
                "\n" +
                "Thank you for registering with our Learning Management System.\n" +
                "\n" +
                "To complete your registration and activate your account, please verify your email address by clicking the link below:\n" +
                "\n" +
                "Verification Link : \n"+link+
                "\n" +
                "This verification step helps us confirm that the email address belongs to you and ensures the security of your account.\n" +
                "\n" +
                "If you did not initiate this registration, please ignore this email or let us know.\n" +
                "\n" +
                "We look forward to having you on our platform.\n" +
                "\n" +
                "Sincerely,  \n" +
                "LMS Registration Team\n";
        return  verify_Mail;
    }

    //function for opt mail content
    public static String getVerifySuccessfullMail() {
        String verify_Mail = "Dear User,\n" +
                "\n" +
                "Your email has been successfully verified, and your registration on the Learning Management System (LMS) is now complete.\n" +
                "\n" +
                "You can now log in to your account and start exploring courses, learning materials, and more.\n" +
                "\n" +
                "We’re excited to have you on board and wish you the best in your learning journey with us.\n" +
                "\n" +
                "If you have any questions or need support, feel free to contact our team.\n" +
                "\n" +
                "Warm regards,  \n" +
                "LMS Team\n";
        return  verify_Mail;
    }

}
