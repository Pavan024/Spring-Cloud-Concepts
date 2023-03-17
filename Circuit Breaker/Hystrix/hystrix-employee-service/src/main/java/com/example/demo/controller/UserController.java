package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.CreateEmployeeResponse;
import com.example.demo.service.EmployeeService;

@RestController
public class UserController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateEmployeeResponse> addEmployee(@RequestBody EmployeeRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.savEmployee(request));
	}

	@GetMapping(value = "/employees/{department}")
	public List<Employee> getUsers(@PathVariable String department) {
		return employeeService.getEmployees(department);

	}

}
