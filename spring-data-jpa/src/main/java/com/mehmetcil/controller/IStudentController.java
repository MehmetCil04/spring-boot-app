package com.mehmetcil.controller;

import java.util.List;

import com.mehmetcil.dto.DtoStudent;
import com.mehmetcil.dto.DtoStudentIU;

public interface IStudentController {
	
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
		
	public List<DtoStudent> getAllStudents();
	
	public DtoStudent getStudentById(Integer id);
	
	public Boolean deleteStudent(Integer id);
	
	public DtoStudent updateStudent(Integer id, DtoStudentIU updateStudent);

}
