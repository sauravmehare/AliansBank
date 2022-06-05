package com.aliens.customer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID;
	@NotBlank(message="name is blank")
	@NotNull(message = "name is null")
	@NotEmpty(message="name is empty")
	private String name;
	
	//@Column(unique=true)
	@NotBlank(message="Email is blank")
	@NotNull(message = "Email is null")
	@NotEmpty(message="Email is empty")
	private String emailId;
	
	@OneToMany(targetEntity = CustomerAddress.class,cascade = CascadeType.ALL)
	@JoinColumn(name="id",referencedColumnName = "ID")
	private List<CustomerAddress> customerAddress;
	
	
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		this.ID = iD;
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
	public List<CustomerAddress> getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(List<CustomerAddress> customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	
	

	

	
}
