package com.mehmetcil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mehmetcil.entites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	//HQL: sınıf isimleri ve değişken isimleriyle sorgu yazılır.
	//SQL: tablo isimleri ve tablodaki kolon isimleriyler sorgu yazılır.
	
	@Query(value = "from Student" , nativeQuery = false)
	List<Student> fingAllStudents();
	
}
