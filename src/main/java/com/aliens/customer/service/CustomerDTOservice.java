package com.aliens.customer.service;

import java.util.List;

import com.aliens.customer.dto.CustomerContact;
import com.aliens.customer.dto.CustomerDTO;
import com.aliens.customer.dto.CustomerProjection;
import com.aliens.customer.entity.Customer;


public interface CustomerDTOservice {
	
	boolean saveCustomer(CustomerDTO customerDTO);
	void deleteCustomerByid(Integer customerId);
	void updateCustomerByid(Integer customerId,CustomerDTO customerDTO);
	Customer getCustomerByid(Integer customerId);
	CustomerProjection findByName(String customerName);
	List<CustomerContact> findByEmailId(String email);

}
