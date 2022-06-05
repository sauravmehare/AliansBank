package com.aliens.exception;

public class CustomerAlreadyExistException extends RuntimeException {
	
	public CustomerAlreadyExistException(String msg) {
		super(msg);
	}

}
