package com.mehmetcil.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehmetcil.dto.DtoStudent;
import com.mehmetcil.dto.DtoStudentIU;
import com.mehmetcil.entites.Student;
import com.mehmetcil.repository.StudentRepository;
import com.mehmetcil.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		DtoStudent response = new DtoStudent();
		Student student = new Student();
		BeanUtils.copyProperties(dtoStudentIU, student);
		Student dbStudent = studentRepository.save(student);
		BeanUtils.copyProperties(dbStudent, response);
		return response;
	}

	@Override
	public List<DtoStudent> getAllStudents() {
		List<DtoStudent> dtoList = new ArrayList<>();
		List<Student> studentList = studentRepository.fingAllStudents();

		for (Student student : studentList) {
			DtoStudent dtoStudent = new DtoStudent();
			BeanUtils.copyProperties(student, dtoStudent);
			dtoList.add(dtoStudent);
		}

		return dtoList;
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		DtoStudent dtoStudent = new DtoStudent();
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			BeanUtils.copyProperties(optional.get(), dtoStudent);
			return dtoStudent;
		}
		return null;
	}

	@Override
	public Boolean deleteStudent(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			studentRepository.delete(optional.get());
			return true;
		}
		return false;
	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU updateStudent) {
		DtoStudent dtoStudent = new DtoStudent();
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {

			optional.get().setFirstName(updateStudent.getFirstName());
			optional.get().setLastName(updateStudent.getLastName());
			optional.get().setBirdOfDate(updateStudent.getBirdOfDate());
			studentRepository.save(optional.get());
			BeanUtils.copyProperties(optional.get(), dtoStudent);

			return dtoStudent;
		}
		return null;
	}

}
