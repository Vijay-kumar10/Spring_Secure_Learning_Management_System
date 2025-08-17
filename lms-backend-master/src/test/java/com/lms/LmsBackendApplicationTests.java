package com.lms;

import com.lms.service.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LmsBackendApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private EmailService emailService;

	@Test
	void sendEmailTest() {
		String mailBody = "Dear User,\n" +
				"\n" +
				"Greetings from [Your Company Name]!\n" +
				"\n" +
				"Thank you for registering with us. We truly appreciate your interest and the time you’ve taken to complete the registration process.\n" +
				"\n" +
				"Please note that this email is being sent purely for testing purposes as part of our internal system verification. No further action is required from your side at this time.\n" +
				"\n" +
				"We are currently running several tests to ensure the best possible user experience and the smooth functioning of our platform. Your participation in this process, even indirectly, is valuable to us.\n" +
				"\n" +
				"Should you receive any similar emails during this testing phase, we kindly request you to disregard them, as they do not reflect actual activity or updates.\n" +
				"\n" +
				"Thank you once again for your understanding and support.\n" +
				"\n" +
				"Warm regards,\n" +
				"[Your Name or Team Name]\n" +
				"[Your Company Name]\n" +
				"[Email Address | Phone Number | Website]";
		emailService.sendEmail("kashyap888985@gmail.com", "Just testing email", mailBody);
	}

}
