package com.telusko.service;

import java.util.List;

import com.telusko.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto empDto);
	EmployeeDto getEmployeeById(long empId);
	List<EmployeeDto> getAllEmployees();
	EmployeeDto updateEmployee(long empId , EmployeeDto updatedEmp);
	void deleteEmployee(long empId);

}
