package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Employee;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeEntity saveEmployee(Employee employee) {
		EmployeeEntity employeeEntity = EmployeeEntity.builder().email(employee.getEmail())
				.firstName(employee.getFirstName()).lastName(employee.getLastName()).build();
		return employeeRepository.save(employeeEntity);
	}

}
