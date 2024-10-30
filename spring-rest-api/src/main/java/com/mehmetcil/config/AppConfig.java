package com.mehmetcil.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mehmetcil.model.Employee;

@Configuration
public class AppConfig {
	
	@Bean
	public List<Employee> employeeList() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("1", "Enes", "Bayram"));
		employeeList.add(new Employee("2", "Mehmet", "Çil"));
		employeeList.add(new Employee("3", "Yasin", "Yazıcı"));
		employeeList.add(new Employee("4", "Harun", "Kazmaalp"));
		employeeList.add(new Employee("5", "Fatih", "Karaca"));
		
		return employeeList;
	}
	
}
