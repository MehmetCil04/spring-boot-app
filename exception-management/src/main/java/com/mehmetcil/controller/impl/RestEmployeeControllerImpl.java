package com.mehmetcil.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetcil.controller.RestEmployeeController;
import com.mehmetcil.dto.DtoEmployee;
import com.mehmetcil.service.IEmployeeService;

@RestController
@RequestMapping(path = "rest/api/employee")
public class RestEmployeeControllerImpl implements RestEmployeeController{
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Override
	@GetMapping("/list/{id}")
	public DtoEmployee findEmployeeById(@PathVariable(value = "id") Long id) {
		return employeeService.findEmployeeById(id);
	}

}
