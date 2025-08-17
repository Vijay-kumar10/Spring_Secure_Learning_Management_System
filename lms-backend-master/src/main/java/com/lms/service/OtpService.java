package com.lms.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OtpService {

    public String otpGenerator() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // Generates a 6-digit number
        return String.valueOf(otp);
    }

    // Example usage
    public static void main(String[] args) {
        OtpService service = new OtpService();
        String otp = service.otpGenerator();
        System.out.println("Generated OTP: " + otp);
    }
}