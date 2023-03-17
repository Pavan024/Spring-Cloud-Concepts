package com.example.demo.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.MqConfig;
import com.example.demo.controller.UserController;
import com.example.demo.request.EmployeeRequest;

@RestController
public class CustomerPublisher {

	@Autowired
	private UserController userController;

	@Autowired
	private RabbitTemplate template;

	@PostMapping("/publish")
	public String publishMessage(@RequestBody EmployeeRequest request) {
		userController.addEmployee(request);
		template.convertAndSend(MqConfig.EXCHANGE, MqConfig.ROUTING_KEY, request);
		return "Customer Created. ";
	}
}
