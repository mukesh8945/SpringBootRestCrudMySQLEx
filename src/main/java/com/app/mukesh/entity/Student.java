package com.app.mukesh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "stdtab")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private Integer studentId;

	@NotNull(message = "Name can not be null")
	@NotEmpty(message = "STUDENT NAME CAN NOT BE EMPTY")
	@NotBlank(message = "STUDENT NAME CAN NOT BE EMPTY")
	@Size(min = 2, max = 6, message = "Only A-Z/a-z are allowed")
	@Column(name = "sname")
	private String studentName;

	@Column(name = "sgen")
	@NotBlank(message = "STUDENT GENDER CAN NOT BE EMPTY")
	private String studentGen;

	@Column(name = "scourse")
	@NotBlank(message = "STUDENT COURSE MUST BE SELECTED")
	private String studentCourse;

	@Column(name = "saddr")
	@Pattern(regexp = "[A-Za-z0-9\\\\.\\\\-\\\\?]{10,250}", message = "INVALID ADDRESS DETAILS")
	private String studentAddress;

}
