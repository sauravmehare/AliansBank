package com.aliens.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import com.aliens.account.dto.AccountDTO;
import com.aliens.account.entity.Account;
import com.aliens.account.repository.AccountRepository;
import com.aliens.account.serviceImpl.AccountServiceImpl;
import com.aliens.customer.entity.Customer;
import com.aliens.customer.entity.CustomerAddress;
import com.aliens.customer.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
	
	@Mock
	AccountRepository accountRepository;
	
	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	
	Account account;
	AccountDTO accountDTO;
	
	Customer expectedCustomer;
	Optional<Customer> expectedCustomers=Optional.ofNullable(expectedCustomer);
	
	@BeforeEach
	public void setUp(){
		account=new Account();
		account.setAccountNo(111L);
		account.setBalance(1000F);
		account.setId(1);
		
		accountDTO=new AccountDTO();
		BeanUtils.copyProperties(account, accountDTO);
		
		List<CustomerAddress> address=new ArrayList<CustomerAddress>();
		address.add(new CustomerAddress(17, "Amravati", 444602L));
		address.add(new CustomerAddress(18, "Nagpur", 444707L));
		
		expectedCustomer=new Customer();
		expectedCustomer.setID(1);
		expectedCustomer.setEmailId("saurav@gmail.com");
		expectedCustomer.setName("saurav");
		expectedCustomer.setCustomerAddress(address);
	}

	
	@Test
	void testGetByAccountNO() {
		when(accountRepository.getById(1L)).thenReturn(account);
		Account found=accountServiceImpl.getByAccountNO(1L);
		assertEquals(account, found);
	}
	
	@Test
	@Disabled
	void testSaveAccount() {
		
		when(accountRepository.save(any(Account.class))).thenAnswer(i ->{
			Account account=i.getArgument(0);
			account.setAccountNo(111L);
			return account;
		});
		when(customerRepository.findById(1)).thenReturn(expectedCustomers);
		boolean found=accountServiceImpl.saveAccount(accountDTO);
		assertEquals(true, found);
	}
	

}
