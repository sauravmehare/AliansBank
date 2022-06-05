package com.aliens.account.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.aliens.exception.AccountNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliens.account.dto.BeneficiaryAccountDTO;
import com.aliens.account.entity.Account;
import com.aliens.account.entity.BeneficiaryAccount;
import com.aliens.account.repository.AccountRepository;
import com.aliens.account.repository.BeneficiaryAccountRepository;
import com.aliens.account.service.BeneficiaryAccountService;

@Service
public class BeneficiaryAccountServiceImpl implements BeneficiaryAccountService {
	
	@Autowired
	BeneficiaryAccountRepository beneficiaryAccountRepository;
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public String saveBeneficiaryAccount(BeneficiaryAccountDTO beneficiaryAccountDTO) {
		Optional<Account> sender=accountRepository.findById(beneficiaryAccountDTO.getSenderAccNo());
		if(sender.isEmpty()) {
			throw new AccountNotFoundException("Sender is not present");
		}
		
		Optional<Account> receiver=accountRepository.findById(beneficiaryAccountDTO.getReceiverAccNo());
		if(receiver.isEmpty()) {
			throw new AccountNotFoundException("Receiver is not present");
		}
		
		BeneficiaryAccount beneficiaryAccount=new BeneficiaryAccount();
		BeanUtils.copyProperties(beneficiaryAccountDTO, beneficiaryAccount);
		System.out.println("Here Am i");
		beneficiaryAccountRepository.save(beneficiaryAccount);
		return "Beneficiary Added";
	}

	@Override
	public String deleteBeneficiary(Integer BenifId) {
		beneficiaryAccountRepository.delete(getbyAccountNo(BenifId));
		return "Beneficiary Removed";
	}

	@Override
	public List<BeneficiaryAccount> getAllbyAccountNo(Long senderAccountNo) {
		List<BeneficiaryAccount> beneficiaryAccounts=beneficiaryAccountRepository.getAllbyAccountNo(senderAccountNo);
		return beneficiaryAccounts;
	}

	@Override
	public BeneficiaryAccount getbyAccountNo(Integer BenifId) {
		BeneficiaryAccount beneficiaryAccount=beneficiaryAccountRepository.getById(BenifId);
		return beneficiaryAccount;
	}

	@Override
	public List<BeneficiaryAccount> getBySenderAndReceiver(Long sender, Long receiver) {
		return beneficiaryAccountRepository.getBySenderAndReceiver(sender, receiver);
	}

}
