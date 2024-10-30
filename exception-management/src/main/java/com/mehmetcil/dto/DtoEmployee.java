package com.mehmetcil.dto;

import com.mehmetcil.model.Depertmant;

import lombok.Data;

@Data
public class DtoEmployee {
	
	private String name;
	
	private DtoDepertmant depertmant;
	
}
