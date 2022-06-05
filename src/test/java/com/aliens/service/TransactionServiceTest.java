package com.aliens.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;

import com.aliens.customer.entity.Customer;
import com.aliens.transaction.controller.TransactionController;
import com.aliens.transaction.dto.TransactionDTO;
import com.aliens.transaction.entity.Transaction;
import com.aliens.transaction.repository.TransactionRepository;
import com.aliens.transaction.serviceImpl.TransactionServiceImpl;

class TransactionServiceTest {

	@Mock
	TransactionRepository transactionRepository;

	@InjectMocks
	TransactionServiceImpl transactionServiceImpl;

	List<Transaction> transactions;
	TransactionDTO transactionDTO;

	@BeforeEach
	void setUp() {
		Transaction transaction;
		transaction=new Transaction();
		transaction.setTransaction(1L);
		transaction.setSenderAccNO(1234L);
		transaction.setReceiverAccNo(1235L);
		transaction.setAmount(500.0F);
		transactions=new ArrayList<Transaction>();
		transactions.add(transaction);
		
		transactionDTO=new TransactionDTO();
		BeanUtils.copyProperties(transaction, transactionDTO);
	}

	@Test
	@Disabled
	void testGetBySenderAndDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy"); 
		String start="01-01-2021";
		String end="01-01-2021";
		LocalDate startDate = LocalDate.parse(start, formatter);
		LocalDate endDate = LocalDate.parse(end, formatter);
		when(transactionRepository.getByDateAndSender(1234L,startDate,endDate)).thenReturn(transactions);
		List<Transaction> found=transactionServiceImpl.getByDateAndSender(1234L, "01-01-2021","01-01-2021");
		assertEquals(transactions.size(), found.size());
	}

	@Test
	@Disabled
	void testSaveTransaction() {
		//when(transactionRepository.save(transaction)
		when(transactionRepository.save(any(Transaction.class))).thenAnswer(i ->{
			Transaction transaction=i.getArgument(0);
			transaction.setTransaction(111L);
			return transaction;
		});
		boolean found=transactionServiceImpl.saveTransaction(transactionDTO);
		assertEquals(true, found);
	}

}
