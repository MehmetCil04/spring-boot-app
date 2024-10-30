package com.mehmetcil.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {
	@NotEmpty(message = "firstName boş bırakılamaz")
	private String firstName;

	private String lastName;

	private Date birdOfDate;
}
