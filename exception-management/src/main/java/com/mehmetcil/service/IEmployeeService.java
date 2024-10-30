package com.mehmetcil.service;

import com.mehmetcil.dto.DtoEmployee;

public interface IEmployeeService {
	
	public DtoEmployee findEmployeeById(Long id);
	
}
