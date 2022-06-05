package com.aliens.customer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.aliens.customer.entity.Customer;

@Entity
public class CustomerAddress {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer addressId;
	
	@NotBlank(message="City is blank")
	@NotNull(message = "City is null")
	@NotEmpty(message="City is empty")
	private String city;
	
	@NotNull(message = "pincode is null")
	private Long pinCode;
	
	//@ManyToOne
	//@JoinColumn(name="ID", referencedColumnName = "ID", insertable = true, updatable = false)
	//private Customer customer; 
	
	public CustomerAddress(Integer addressId, String city, Long pinCode) {
		this.addressId = addressId;
		this.city = city;
		this.pinCode = pinCode;
	}
	
	public CustomerAddress() {
	
	}
	
	public Integer getAddressId() {
		return addressId;
	}


	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPinCode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	@Override
//	public String toString() {
//		return "CustomerAddress [addressId=" + addressId + ", city=" + city + ", pinCode=" + pinCode + ", customer="
//				+ customer + "]";
//	}
	
	
	

}
