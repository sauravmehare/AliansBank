package com.aliens.exception;

import java.util.HashMap;
import java.util.Map;

public class ValidationErrorResponce extends ErrorResponce {
	private Map<String,String> errors=new HashMap<String,String>();

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	

}
