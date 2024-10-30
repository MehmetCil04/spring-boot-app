package com.mehmetcil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehmetcil.model.Employee;
import com.mehmetcil.model.UpdateEmployeeRequest;
import com.mehmetcil.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getEmployeeList() {
		// 100 lerce satır kontrol yapacaksın.
		return employeeRepository.getEmployeeList();
	}

	public Employee getEmployeeById(String id) {
		return employeeRepository.getEmployeeById(id);

	}

	public List<Employee> getEmployeeWithParams(String firstName, String lastName) {

		return employeeRepository.getEmployeeWithParams(firstName, lastName);
	}

	public Employee saveEmployee(Employee newEmployee) {
		return employeeRepository.saveEmployee(newEmployee);
	}
	public boolean deleteEmployee(String id) {
		return employeeRepository.deleteEmployee(id);
	}
	public Employee updateEmployee(String id, UpdateEmployeeRequest request) {
		return employeeRepository.updateEmployee(id, request);
	}
}
