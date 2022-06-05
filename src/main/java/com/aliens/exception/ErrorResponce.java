package com.aliens.exception;

import java.time.LocalDateTime;

public class ErrorResponce {
	private String message;
	private Integer statusCode;
	private LocalDateTime dateTime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int i) {
		this.statusCode = i;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	

}
