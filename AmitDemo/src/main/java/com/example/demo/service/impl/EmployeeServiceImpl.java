package com.example.demo.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeeRequest;
import com.example.demo.model.EmployeeResponse;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
		Employee emp = setEmployee(employeeRequest);
		emp = employeeRepository.save(emp);
		EmployeeResponse empResponse = setEmployeeResponse(emp);
		return empResponse;
	}

	private EmployeeResponse setEmployeeResponse(Employee emp) {
		EmployeeResponse EmployeeResponse = new EmployeeResponse();
		EmployeeResponse.setAddress(emp.getAddress());
		EmployeeResponse.setAge(emp.getAge());
		EmployeeResponse.setDateOfJoining(emp.getDateOfJoining());
		EmployeeResponse.setDesignation(emp.getDesignation());
		EmployeeResponse.setEmail(emp.getEmail());
		EmployeeResponse.setEmpId(emp.getEmpId());
		EmployeeResponse.setEmpName(emp.getEmpName());
		EmployeeResponse.setSalary(emp.getSalary());
		EmployeeResponse.setUpdatedDate(emp.getUpdatedDate());
		return EmployeeResponse;
	}

	private Employee setEmployee(EmployeeRequest employeeRequest) {
		Employee employee = new Employee();
		employee.setAddress(employeeRequest.getAddress());
		employee.setAge(employeeRequest.getAge());
		employee.setDateOfJoining(employeeRequest.getDateOfJoining());
		employee.setEmail(employeeRequest.getEmail());
		employee.setEmpName(employeeRequest.getEmpName());
		employee.setSalary(employeeRequest.getSalary());
		employee.setUpdatedDate(LocalDateTime.now());
		employee.setDesignation(employeeRequest.getDesignation());
		return employee;
	}

}
