package com.app.mukesh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mukesh.entity.Student;
import com.app.mukesh.service.IStudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/api/student")
@CrossOrigin("*")
public class StudentRestController {

	@Autowired
	public IStudentService service;

//	1. CREATE ONE STUDENT
	public ResponseEntity<String> createStudent(@RequestBody @Valid Student student) {
		Integer id = service.saveStudent(student);
		String message = "STUDENT ' " + id + " ' CREATED";
		return new ResponseEntity<String>(message, HttpStatus.CREATED); //201
	}

}
