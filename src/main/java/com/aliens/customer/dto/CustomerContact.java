package com.aliens.customer.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.aliens.customer.entity.CustomerAddress;

public class CustomerContact {
	private String name;
	private String emailId;

	
	public CustomerContact(String name, String emailId) {
		this.name = name;
		this.emailId = emailId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}	

}
