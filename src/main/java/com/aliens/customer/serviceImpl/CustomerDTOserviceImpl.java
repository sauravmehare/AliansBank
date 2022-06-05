package com.aliens.customer.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliens.customer.dto.CustomerContact;
import com.aliens.customer.dto.CustomerDTO;
import com.aliens.customer.dto.CustomerProjection;
import com.aliens.customer.entity.Customer;
import com.aliens.customer.repository.CustomerRepository;
import com.aliens.customer.service.CustomerDTOservice;
import com.aliens.exception.CustomerAlreadyExistException;

@Service
public class CustomerDTOserviceImpl implements CustomerDTOservice {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public boolean saveCustomer(CustomerDTO customerDTO) {
		Customer customer=new Customer();
		BeanUtils.copyProperties(customerDTO, customer); 
		
		List<CustomerContact> testEmail=findByEmailId(customer.getEmailId());
		if(!testEmail.isEmpty()) {
			throw new CustomerAlreadyExistException("MailId already in use or account exist");
		}
		Customer savedCustomer=customerRepository.save(customer);
		if(savedCustomer!=null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void updateCustomerByid(Integer customerId,CustomerDTO customerDTO) {
		Customer customer=getCustomerByid(customerId);
		customer.setEmailId(customerDTO.getEmailId());
		customer.setName(customerDTO.getName());
		//deleteCustomerByid(customerId);
		customerRepository.save(customer);
	
		
	}

	@Override
	public Customer getCustomerByid(Integer customerId) {
		Customer customer=new Customer();
		customer=customerRepository.getById(customerId);
		return customer;
	}

	@Override
	public void deleteCustomerByid(Integer customerId) {
		customerRepository.delete(getCustomerByid(customerId));		
	}

	@Override
	public CustomerProjection findByName(String customerName) {
		return customerRepository.findByName(customerName);
	}

	@Override
	public List<CustomerContact> findByEmailId(String customerName) {
		return customerRepository.findByEmailId(customerName);
	}


	
}
