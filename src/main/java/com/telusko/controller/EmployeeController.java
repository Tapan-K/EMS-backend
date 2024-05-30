package com.telusko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.Dao.EmployeeRepository;
import com.telusko.dto.EmployeeDto;
import com.telusko.model.Employee;
import com.telusko.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

	@Autowired
	private EmployeeService service;

	// Building add employee restAPI

	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto empDto) {

		EmployeeDto savedEmployee = service.createEmployee(empDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

	}

	// Building get single employee restAPI
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") long empId) {
		EmployeeDto employeeDto = service.getEmployeeById(empId);
		return ResponseEntity.ok(employeeDto);
	}

	// Building getAll employee restAPI
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		List<EmployeeDto> employees = service.getAllEmployees();
		return ResponseEntity.ok(employees);
	}

	// update employee Rest API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") long empId, @RequestBody EmployeeDto empDto) {
		EmployeeDto employeeDto = service.updateEmployee(empId, empDto);
		return ResponseEntity.ok(employeeDto);
	}

	// Delete Employee Rest API

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long empId) {
		service.deleteEmployee(empId);
		return ResponseEntity.ok("Employee deleted successfully");
	}

}
