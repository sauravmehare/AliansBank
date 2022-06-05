package com.aliens.customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aliens.customer.dto.CustomerContact;
import com.aliens.customer.dto.CustomerDTO;
import com.aliens.customer.dto.CustomerProjection;
import com.aliens.customer.entity.Customer;
import com.aliens.customer.service.CustomerDTOservice;
import com.aliens.transaction.controller.TransactionController;
import com.fasterxml.jackson.annotation.JsonIgnore;


@RestController
public class CustomerController {
	@Autowired
	CustomerDTOservice customerDTOservice;
	
	protected final static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	//Adding Customer
	@PostMapping("/customer")
	public ResponseEntity<String> saveCustomer(@RequestBody CustomerDTO customerDTO) {
		boolean saveMsg=customerDTOservice.saveCustomer(customerDTO);
		logger.info("Customer data is saved");
		if(saveMsg==true) {
			return new ResponseEntity<String> ("Customer data is saved",HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String> ("Customer data is not saved",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	//Deleting Customer
	@DeleteMapping("/customer/{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Integer customerId) {
		logger.info("Data is getting deleted");
		customerDTOservice.deleteCustomerByid(customerId);
	}
	
	//Getting Customer by ID
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") Integer customerId) {
		logger.info("Customer fetching by Id");
		return new ResponseEntity<Customer> ((Customer)customerDTOservice.getCustomerByid(customerId),HttpStatus.OK);
	}
	
	//Getting Customer by Name
	@GetMapping("/customer/name/{customerName}")
	public ResponseEntity<CustomerProjection> getCustomerByName(@PathVariable("customerName") String customerName) {
		logger.info("Customer fetching by Name");
		return new ResponseEntity<CustomerProjection> (customerDTOservice.findByName(customerName),HttpStatus.OK);
	}
	
	//Getting Customer by MailId
	@GetMapping("/customer/email/{emailId}")
	public ResponseEntity<List<CustomerContact>> getCustomerByEmailID(@PathVariable("emailId") String emailId) {
		logger.info("Customer fetching by Email");
		return new ResponseEntity<List<CustomerContact>> (customerDTOservice.findByEmailId(emailId),HttpStatus.OK);
	}
	
	//Updating Customer by ID
	@PutMapping("/customer/{customerId}")
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody CustomerDTO customerDTO) {
		customerDTOservice.updateCustomerByid(customerId,customerDTO);
		logger.info("Updating Customer");
		return new ResponseEntity<CustomerDTO> (customerDTO,HttpStatus.OK);
	}


}
