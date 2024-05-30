package com.telusko.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.telusko.Dao.EmployeeRepository;
import com.telusko.dto.EmployeeDto;
import com.telusko.exception.ResourceNotFoundException;
import com.telusko.mapper.EmployeeMapper;
import com.telusko.model.Employee;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository repo;

	@Override
	public EmployeeDto createEmployee(EmployeeDto empDto) {

		Employee employee = EmployeeMapper.mapToEmployee(empDto);
		Employee savedEmployee = repo.save(employee);

		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(long empId) {

		Employee employee = repo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exist with the given id :" + empId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = repo.findAll();
		return employees.stream().map((emp) -> EmployeeMapper.mapToEmployeeDto(emp)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(long empId, EmployeeDto updatedEmp) {
		Employee employee = repo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee is Not Exits with the Id :" + empId));

		employee.setFirstName(updatedEmp.getFirstName());
		employee.setLastName(updatedEmp.getLastName());
		employee.setEmailId(updatedEmp.getEmailId());

		Employee updatedEmployee = repo.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
	}

	@Override
	public void deleteEmployee(long empId) {

		Employee employee = repo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee is Not Exits with the Id :" + empId));

		repo.deleteById(empId);

	}

}
