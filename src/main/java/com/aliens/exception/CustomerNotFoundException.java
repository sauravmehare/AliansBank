package com.aliens.exception;

public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException(String message) {
		super(message);
	}

}
