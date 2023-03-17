package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface EmployeeRepository extends JpaRepository<Student, Long> {

	Optional<Student> findByEmailId(String emailId);
	
	List<Student> findByDepartment(String department);
	


}
