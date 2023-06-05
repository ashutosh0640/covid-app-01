package com.vaccinationApp.exceptions;

public class UserException extends RuntimeException{

	public UserException(String message) {
		super(message);
		
	}
	public UserException() {
		super();
		
	}
}
