package com.app.mukesh.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.mukesh.exception.StudentNotFoundException;

@RestControllerAdvice
public class MyCustomExceptionHandler {
	public ResponseEntity<String> showStudentNotFoundError(StudentNotFoundException snfe) {
		return new ResponseEntity<>(snfe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
