package com.app.mukesh.exception;

@SuppressWarnings("serial")
public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException() {
		super();
	}

	public StudentNotFoundException(String msg) {
		super(msg);
	}

}
