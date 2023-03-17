package com.config.demo.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance-service")
public class InsuranceController {
	
	@GetMapping("/getUpdatePlans")
	public List<String> getPlans(){
		return Stream.of("Premium","Gold","Platinum").toList();
	}
}
