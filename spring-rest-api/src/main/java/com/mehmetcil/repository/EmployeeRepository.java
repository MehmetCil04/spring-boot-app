package com.mehmetcil.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mehmetcil.config.AppConfig;
import com.mehmetcil.model.Employee;
import com.mehmetcil.model.UpdateEmployeeRequest;

@Repository
public class EmployeeRepository {

	@Autowired
	private List<Employee> employeeList;

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public Employee getEmployeeById(String id) {
		Employee findEmployee = null;
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				findEmployee = employee;
				break;
			}
		}
		return findEmployee;
	}

	public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
		List<Employee> employeewithParams = new ArrayList<>();
		if (firstName == null && lastName == null) {
			return employeeList;
		}
		for (Employee employee : employeeList) {
			if (firstName != null && lastName != null) {
				if (employee.getFirstName().equalsIgnoreCase(firstName)
						&& employee.getLastName().equalsIgnoreCase(lastName)) {
					employeewithParams.add(employee);
				}
			}
			if (firstName != null && lastName == null) {
				if (employee.getFirstName().equalsIgnoreCase(firstName)) {
					employeewithParams.add(employee);
				}
			}
			if (firstName == null && lastName != null) {
				if (employee.getLastName().equalsIgnoreCase(lastName)) {
					employeewithParams.add(employee);
				}
			}
		}

		return employeewithParams;
	}

	public Employee saveEmployee(Employee newEmployee) {
		employeeList.add(newEmployee);
		return newEmployee;
	}

	public boolean deleteEmployee(String id) {
		// delete from Employee Where id = :id 
		Employee deleteEmployee=null;
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				deleteEmployee = employee;
				break;
			}
		}
		if (deleteEmployee == null) {
			return false;
		}
		employeeList.remove(deleteEmployee);
		return true;
	}
	
	private Employee findEmployeeById(String id) {
		Employee findEmployee = null;
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				findEmployee = employee;
				break;
			}		
		}
		return findEmployee;
	}
	
	public Employee updateEmployee(String id , UpdateEmployeeRequest request) {
		Employee findEmployee = findEmployeeById(id);
		if (findEmployee != null) {
			deleteEmployee(id);
			
			Employee updateEmployee = new Employee();
			updateEmployee.setId(id);
			updateEmployee.setFirstName(request.getFirstName());
			updateEmployee.setLastName(request.getLastName());
			 
			employeeList.add(updateEmployee);
			return updateEmployee;
		}
		return null;
	}
	
}
