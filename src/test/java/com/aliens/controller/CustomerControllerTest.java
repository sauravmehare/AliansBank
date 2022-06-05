package com.aliens.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.aliens.customer.controller.CustomerController;
import com.aliens.customer.dto.CustomerContact;
import com.aliens.customer.dto.CustomerDTO;
import com.aliens.customer.entity.Customer;
import com.aliens.customer.entity.CustomerAddress;
import com.aliens.customer.service.CustomerDTOservice;

import lombok.CustomLog;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {
	
	@Mock
	CustomerDTOservice customerDTOservice;
	
	@InjectMocks
	CustomerController customerController;
	
	Customer expectedCustomer;
	CustomerDTO customerDTO;
	List<CustomerContact> customerContacts;
	
	@BeforeEach
	public void setUp(){
		List<CustomerAddress> address=new ArrayList<CustomerAddress>();
		address.add(new CustomerAddress(17, "Amravati", 444602L));
		address.add(new CustomerAddress(18, "Nagpur", 444707L));
		
		expectedCustomer=new Customer();
		expectedCustomer.setID(16);
		expectedCustomer.setEmailId("saurav@gmail.com");
		expectedCustomer.setName("saurav");
		expectedCustomer.setCustomerAddress(address);
		
		customerDTO=new CustomerDTO();
		customerDTO.setEmailId("saurav@gmail.com");
		customerDTO.setName("saurav");
		customerDTO.setCustomerAddress(address);
		
		customerContacts=new ArrayList<CustomerContact>();
		CustomerContact cc=new CustomerContact("saurav","saurav@gmail.com");
		customerContacts.add(cc);
	}

	@Test
	void testGetCustomer() {
		when(customerDTOservice.getCustomerByid(1)).thenReturn(expectedCustomer);
		ResponseEntity<Customer> foundCustomer=customerController.getCustomer(1);
		assertEquals(expectedCustomer, foundCustomer.getBody());
		assertEquals(foundCustomer.getStatusCode(), foundCustomer.getStatusCode());
		
	}
	
	@Test
	void testGetCustomerByEmailID() {
		when(customerDTOservice.findByEmailId("saurav@gmail.com")).thenReturn(customerContacts);
		ResponseEntity<List<CustomerContact>> foundCustomer=customerController.getCustomerByEmailID("saurav@gmail.com");
		assertEquals(customerContacts, foundCustomer.getBody());
		assertEquals(foundCustomer.getStatusCode(), foundCustomer.getStatusCode());
	}
	
	@Test
	void testSaveCustomerPostive() {
		when(customerDTOservice.saveCustomer(customerDTO)).thenReturn(true);
		ResponseEntity<String> found=customerController.saveCustomer(customerDTO);
		assertEquals("Customer data is saved", found.getBody());
		assertEquals(found.getStatusCode(), found.getStatusCode());
		
	}
	
	@Test
	void testSaveCustomerNegative() {
		when(customerDTOservice.saveCustomer(customerDTO)).thenReturn(false);
		ResponseEntity<String> found=customerController.saveCustomer(customerDTO);
		assertEquals("Customer data is not saved", found.getBody());
		assertEquals(found.getStatusCode(), found.getStatusCode());
		
	}

	
}
