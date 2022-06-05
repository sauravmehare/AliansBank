package com.aliens.transaction.serviceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.aliens.account.entity.Account;
import com.aliens.account.entity.BeneficiaryAccount;
import com.aliens.account.repository.AccountRepository;
import com.aliens.account.repository.BeneficiaryAccountRepository;
import com.aliens.exception.AccountNotFoundException;
import com.aliens.exception.BeneficiaryNotFoundException;
import com.aliens.exception.ZeroAmountExceprion;
import com.aliens.transaction.dto.TransactionDTO;
import com.aliens.transaction.entity.Transaction;
import com.aliens.transaction.repository.TransactionRepository;
import com.aliens.transaction.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	BeneficiaryAccountRepository beneficiaryAccountRepository;



	@Override
	@Transactional
	public boolean saveTransaction(TransactionDTO transactionDTO) {
		Transaction transaction=new Transaction();
		BeanUtils.copyProperties(transactionDTO, transaction);
		transaction.setLocalDate(LocalDate.now());
		transaction.setLocalTime(LocalTime.now());

		Optional<Account> send=accountRepository.findById(transactionDTO.getSenderAccNO());
		if(send.isEmpty()) {
			throw new AccountNotFoundException("Add valid sender account number.");	
		}
		Account sender=send.get();

		Optional<Account> rece=accountRepository.findById(transactionDTO.getReceiverAccNo());
		if(rece.isEmpty()) {
			throw new AccountNotFoundException("Add valid receiver account number");
		}
		Account receiver=rece.get();

		List<BeneficiaryAccount> benifList=beneficiaryAccountRepository.getBySenderAndReceiver(transactionDTO.getSenderAccNO(),transactionDTO.getReceiverAccNo());
		if(benifList.isEmpty()) {
			throw new BeneficiaryNotFoundException("Please enter valid beneficiary.");
		}

		if(transactionDTO.getAmount()<=0.0) {
			throw new ZeroAmountExceprion("You can not transfer 0 balance");
		}

		if(sender.getBalance()<transaction.getAmount()) {
			//return "Insufficient Balance";
		}

		sender.setBalance(sender.getBalance()-transaction.getAmount());
		accountRepository.save(sender);
		receiver.setBalance(receiver.getBalance()+transaction.getAmount());
		accountRepository.save(receiver);
		Transaction savedTransaction=transactionRepository.save(transaction);
		if(savedTransaction!=null) {
			return true;
		}
		else {
			return false;
		}


	}



	@Override
	public List<Transaction> getByDateAndSender(Long senderAccNO, String startDate,
			String endDate) {
		//		String str = "12-15-2021"; 
		//		String str2 = "12-15-2021";
		//		Long senderAccNO=124L;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy"); 
		LocalDate startDateTime = LocalDate.parse(startDate, formatter);
		LocalDate endDateTime = LocalDate.parse(endDate, formatter);
		System.out.println("I am here"+startDateTime);
		System.out.println(LocalDateTime.now());
		System.out.println(startDateTime);
		List<Transaction> trn=transactionRepository.getByDateAndSender(senderAccNO, startDateTime, endDateTime);
		return trn;
	}

}
