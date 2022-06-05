package com.aliens.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import com.aliens.account.dto.BeneficiaryAccountDTO;
import com.aliens.account.entity.BeneficiaryAccount;
import com.aliens.account.repository.BeneficiaryAccountRepository;

public interface BeneficiaryAccountService {
	
	String saveBeneficiaryAccount(BeneficiaryAccountDTO beneficiaryAccountDTO);
	String deleteBeneficiary(Integer BenifId);
	List<BeneficiaryAccount> getAllbyAccountNo(Long accountNo);
	BeneficiaryAccount getbyAccountNo(Integer BenifId);
	List<BeneficiaryAccount> getBySenderAndReceiver(@Param("sender") Long sender,@Param("receiver") Long receiver);
	
	
}
