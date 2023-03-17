package com.emailservice.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.emailservice.service.EmailService;

@RestController
public class SendEmailController {

	@Autowired
	private EmailService emailService;

//	@GetMapping("/testSendEmail")
	public String sendEmail(String emailId) {
		try {
			emailService.sendMail(emailId, "Registration Successfull",
					"You have successfully registered. \n"+
			" All your details have been saved in our records \n" + "Thank you");
			System.out.println("Mail sent");
			return "Mail Sent";
			
		} catch (MessagingException e) {
			e.printStackTrace();
			return "Failed to sent mail";
		}
	}
	


}