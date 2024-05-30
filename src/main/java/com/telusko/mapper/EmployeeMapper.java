package com.telusko.mapper;

import com.telusko.dto.EmployeeDto;
import com.telusko.model.Employee;

public class EmployeeMapper {

	public static EmployeeDto mapToEmployeeDto(Employee employee) {

		// Converts employee entity to empDto object

		return new EmployeeDto(

				employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailId()

		);
	}

	public static Employee mapToEmployee(EmployeeDto empDto) {

		return new Employee(

				empDto.getId(), empDto.getFirstName(), empDto.getLastName(), empDto.getEmailId()

		);

	}

}
