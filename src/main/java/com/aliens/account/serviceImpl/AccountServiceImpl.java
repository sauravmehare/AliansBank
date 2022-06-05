package com.aliens.account.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliens.account.dto.AccountDTO;
import com.aliens.account.entity.Account;
import com.aliens.account.repository.AccountRepository;
import com.aliens.account.service.AccountService;
import com.aliens.customer.entity.Customer;
import com.aliens.customer.repository.CustomerRepository;
import com.aliens.exception.CustomerNotFoundException;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public boolean saveAccount(AccountDTO accountDTO) {
		Optional<Customer> optionalCustomer=customerRepository.findById(accountDTO.getId());
		if(optionalCustomer.isEmpty()) throw new CustomerNotFoundException("Customer dose not exist for the ID"+accountDTO.getId());
		Account account= new Account();
		BeanUtils.copyProperties(accountDTO, account);
	
		Account savedAccount=accountRepository.save(account);
		
		if(savedAccount != null) return true;
		return false;
	}


	@Override
	public String deleteAccountByid(Long accountNO) {
		accountRepository.delete(getByAccountNO(accountNO));	
		return "Account deleted";
	}

	@Override
	public String updateAccountBalance(Long accountNO, Float amount) {
		Account acc=getByAccountNO(accountNO);
		acc.setBalance(acc.getBalance()+amount);
		accountRepository.save(acc);
		return "Your account balance is "+acc.getBalance();
	}


	@Override
	public Account getByAccountNO(Long accountNO) {
		return accountRepository.getById(accountNO);
	}


	@Override
	public Account findByCustId(Long custId) {
		return accountRepository.findByCustId(custId);
	}

}
