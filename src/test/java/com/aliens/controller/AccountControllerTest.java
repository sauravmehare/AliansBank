package com.aliens.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aliens.account.controller.AccountController;
import com.aliens.account.dto.AccountDTO;
import com.aliens.account.entity.Account;
import com.aliens.account.service.AccountService;
import com.aliens.account.serviceImpl.AccountServiceImpl;
import com.aliens.customer.controller.CustomerController;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest {

	//@Mock
	//AccountServiceImpl accountServiceImpl;
	
	@Mock
	AccountService accountServiceImpl;

	@InjectMocks
	AccountController accountController;

	AccountDTO accountDTO;

	@BeforeEach
	public void setUp(){
		accountDTO=new AccountDTO();
		accountDTO.setAccountNo(111L);
		accountDTO.setBalance(1000F);
		accountDTO.setId(1);
	}
	
	@Test
	void testUpdateAccountBalance() {
		when(accountServiceImpl.updateAccountBalance(111L, 500F)).thenReturn("Your account balance is 1500.0");
		String found=accountController.updateAccountBalance(111L, 500F);
		assertEquals("Your account balance is 1500.0", found);
		
	}

	@Test
	void testDeleteAccountByid() {
		when(accountServiceImpl.deleteAccountByid(111L)).thenReturn("Account deleted");
		String found=accountController.deleteAccountByid(111L);
		assertEquals("Account deleted", found);
	}

	@Test
	void testSaveAccountPositive() {
		when(accountServiceImpl.saveAccount(accountDTO)).thenReturn(true);
		String found=accountController.saveAccount(accountDTO);
		assertEquals("Account is added", found);
	}
	
	@Test
	void testSaveAccountNgative() {
		when(accountServiceImpl.saveAccount(accountDTO)).thenReturn(false);
		String found=accountController.saveAccount(accountDTO);
		assertEquals("Account is not added", found);
	}
  
	

}
