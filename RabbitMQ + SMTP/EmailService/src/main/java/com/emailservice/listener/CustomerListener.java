package com.emailservice.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emailservice.config.MqConfig;
import com.emailservice.controller.SendEmailController;
import com.example.demo.request.EmployeeRequest;

@Component
public class CustomerListener {

	@Autowired
	private SendEmailController sendEmailController;

	@RabbitListener(queues = MqConfig.QUEUE)
	public void listener(EmployeeRequest request) {
		sendEmailController.sendEmail(request.getEmailId());
		System.out.println(request);
		
	}
	
	
}