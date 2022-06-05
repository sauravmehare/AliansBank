package com.aliens.account.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aliens.account.dto.AccountDTO;
import com.aliens.account.entity.Account;
import com.aliens.account.service.AccountService;
import com.aliens.customer.controller.CustomerController;

@RestController
public class AccountController {
	@Autowired
	AccountService accountService;
	
	protected final static Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	//Adding Account
	@PostMapping(value="/account",consumes =MediaType.APPLICATION_JSON_VALUE)
	public String saveAccount(@Valid @RequestBody AccountDTO accountDTO) {
		boolean msg=accountService.saveAccount(accountDTO);
		logger.info("Account data is being saved");
		if(msg==true) {
			return "Account is added";
		}
		else {
			return "Account is not added";
		}
	
	}
	
	//Updating Balance
	@PutMapping(value="/account/acc/{accountNO}/amt/{amount}")
	public String updateAccountBalance(@PathVariable("accountNO") Long accountNO,@PathVariable("amount") Float amount) {
		logger.info("Balance Updated");
		return accountService.updateAccountBalance(accountNO, amount);
	}
	
	//Deleting Account
	@DeleteMapping(value="/account/acc/{accountNO}")
	public String deleteAccountByid(@PathVariable("accountNO") Long accountNO) {
		logger.info("Account deleted");
		return accountService.deleteAccountByid(accountNO);
	}
	
	@GetMapping(value="/account/acc/{accountNO}")
	public Account getByAccountNO(@PathVariable("accountNO") Long accountNO) {
		logger.info("Fetching Account Info.");
		return accountService.getByAccountNO(accountNO);
	}

}
