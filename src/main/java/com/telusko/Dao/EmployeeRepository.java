package com.telusko.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
