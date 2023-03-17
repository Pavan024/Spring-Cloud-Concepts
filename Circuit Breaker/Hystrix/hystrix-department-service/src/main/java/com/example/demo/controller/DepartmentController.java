package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EmployeeService;

@RestController
public class DepartmentController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/departmentDetails/{department}")
	public String getEmployees(@PathVariable String department) {
		System.out.println("Going to call student service to get data!");
		return employeeService.callEmployeeServiceAndGetData(department);
	}

}
