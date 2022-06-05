package com.aliens.account.service;

import com.aliens.account.dto.AccountDTO;
import com.aliens.account.entity.Account;
import com.aliens.customer.dto.CustomerDTO;


public interface AccountService {
	boolean saveAccount(AccountDTO accountDTO);
	String deleteAccountByid(Long accountNO);
	String updateAccountBalance(Long accountNO,Float amount);
	Account getByAccountNO(Long accountNO);
	Account findByCustId(Long custId);
	

}
