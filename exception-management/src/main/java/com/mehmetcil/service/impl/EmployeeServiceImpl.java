package com.mehmetcil.service.impl;

import java.beans.beancontext.BeanContext;
import java.util.Optional;
import java.util.logging.ErrorManager;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehmetcil.dto.DtoDepertmant;
import com.mehmetcil.dto.DtoEmployee;
import com.mehmetcil.exception.BaseException;
import com.mehmetcil.exception.ErrorMessage;
import com.mehmetcil.exception.MessageType;
import com.mehmetcil.model.Employee;
import com.mehmetcil.repository.IEmployeeRepository;
import com.mehmetcil.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Override
	public DtoEmployee findEmployeeById(Long id) {
		DtoEmployee dto = new DtoEmployee();
		DtoDepertmant dtoDepertmant = new DtoDepertmant();
		
		Optional<Employee> optional	= employeeRepository.findById(id);
		
		if (optional.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
		}
		
		Employee employee = optional.get();
		BeanUtils.copyProperties(employee, dto);
		BeanUtils.copyProperties(employee.getDepertmant(), dtoDepertmant);
		dto.setDepertmant(dtoDepertmant);
		return dto;
	}

}
