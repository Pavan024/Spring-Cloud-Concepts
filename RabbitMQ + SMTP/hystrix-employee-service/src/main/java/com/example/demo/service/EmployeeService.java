package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.Constants;
import com.example.demo.entity.Student;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.CreateEmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public CreateEmployeeResponse savEmployee(EmployeeRequest request) {

		Optional<Student> userOptional = employeeRepository.findByEmailId(request.getEmailId());
		if (userOptional.isPresent()) {
			throw new BadRequestException(Constants.USER_ALREADY_PRESENT);
		}

		Student employee = new Student();
		employee.setCreatedAt(LocalDateTime.now());
		employee.setUpdatedAt(LocalDateTime.now());
		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setEmailId(request.getEmailId());
		employee.setPhoneNo(request.getPhoneNo());
		employee.setDepartment(request.getDepartment());
		employeeRepository.save(employee);

		return createEmployeeResponse(employee);

	}

	public static CreateEmployeeResponse createEmployeeResponse(Student user) {
		CreateEmployeeResponse response = new CreateEmployeeResponse();
		response.setStatus(Constants.SUCCESS);
		response.setId(user.getId());
		response.setFirstName(user.getFirstName());
		response.setMessage(Constants.USER_ADDED_SUCCESSFULLY);
		return response;
	}

	public List<Student> getEmployees(String department) {

		return employeeRepository.findByDepartment(department);
	}

}
