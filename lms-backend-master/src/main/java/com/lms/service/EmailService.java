package com.lms.service;

public interface EmailService {

    void sendEmail(String to, String subject, String body);

    void sendHtmlEmail();

    void sendAttachmentsEmail();

}
