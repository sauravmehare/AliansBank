package com.aliens.service;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.aliens.customer.dto.CustomerContact;
import com.aliens.customer.dto.CustomerDTO;
import com.aliens.customer.entity.Customer;
import com.aliens.customer.entity.CustomerAddress;
import com.aliens.customer.repository.CustomerRepository;
import com.aliens.customer.service.CustomerDTOservice;
import com.aliens.customer.serviceImpl.CustomerDTOserviceImpl;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	CustomerDTOserviceImpl customerDTOserviceImpl;

	Customer expectedCustomer;
	List<CustomerContact> customerContactList;
	CustomerContact customerContact;
	CustomerDTO customerDTO;

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

		customerContact=new CustomerContact("saurav", "saurav@gmail.com");
		//customerContact.setEmailId("saurav@gmail.com");
		//customerContact.setName("saurav");
		customerContactList=new ArrayList<CustomerContact>();
		customerContactList.add(customerContact);
		
		customerDTO=new CustomerDTO();
		BeanUtils.copyProperties(expectedCustomer, customerDTO);
	}

	@Test
	void testGetCustomerByid() {
		when(customerRepository.getById(1)).thenReturn(expectedCustomer);
		Customer foundCustomer=customerDTOserviceImpl.getCustomerByid(1);
		assertEquals(expectedCustomer, foundCustomer);
	}


	@Test
	void testFindByEmailId() {
		when(customerRepository.findByEmailId("saurav@gmail.com")).thenReturn(customerContactList);
		List<CustomerContact> foundList=customerDTOserviceImpl.findByEmailId("saurav@gmail.com");
		assertEquals(customerContactList, foundList);
	}
	
	@Test
	void testSaveCustomer() {
		when(customerRepository.save(any(Customer.class))).thenAnswer(i ->{
			Customer customer=i.getArgument(0);
			customer.setID(1);
			return customer;
		});
		boolean found=customerDTOserviceImpl.saveCustomer(customerDTO);
		assertEquals(true, found);
	}

}
