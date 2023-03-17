package com.example.demo.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EmployeeService {

	private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "callEMployeeServiceAndGetData_Fallback")
	public String callEmployeeServiceAndGetData(String department) {
		logger.info("Getting Department details for " + department);
		String response = restTemplate.exchange("http://localhost:9091/employees/{department}", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}, department).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - Department Name -  " + department + " :::  EMployee Details " + response + " -  "
				+ new Date();
	}

	@SuppressWarnings("unused")
	private String callEMployeeServiceAndGetData_Fallback(String department) {
		logger.info("Employee Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Employee Service at this moment. Service will be back shortly - "
				+ new Date();
	}

}
