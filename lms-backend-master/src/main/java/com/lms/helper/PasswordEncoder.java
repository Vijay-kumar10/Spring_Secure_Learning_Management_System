package com.lms.helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

public class PasswordEncoder {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public PasswordEncoder() {
    }
    public String encode(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    public static void main(String[] args) {
        PasswordEncoder encoder = new PasswordEncoder();
        System.out.println(encoder.encode("123456"));
    }
}

