package com.mehmetcil.controller;

import com.mehmetcil.dto.DtoEmployee;

public interface RestEmployeeController {

	public DtoEmployee findEmployeeById(Long id);
	
}
