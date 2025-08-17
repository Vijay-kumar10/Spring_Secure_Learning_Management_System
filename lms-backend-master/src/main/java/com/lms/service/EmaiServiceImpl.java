package com.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmaiServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender mailSender;

    //this is used for if we use mailsTrap service
//    @Value("${spring.mail.properties.domain_name}")
//    private String domainName;

    @Override
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
//        message.setFrom(domainName);
        mailSender.send(message);
    }

    @Override
    public void sendHtmlEmail() {

    }

    @Override
    public void sendAttachmentsEmail() {

    }
}
