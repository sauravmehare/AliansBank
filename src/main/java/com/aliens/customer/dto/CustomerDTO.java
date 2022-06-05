package com.aliens.customer.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.aliens.customer.entity.CustomerAddress;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
public class CustomerDTO {
	

	private String name;
	private String emailId;
	private List<CustomerAddress> customerAddress;
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
	public List<CustomerAddress> getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(List<CustomerAddress> customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	
	
}
