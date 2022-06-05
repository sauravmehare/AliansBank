package com.aliens.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import com.aliens.transaction.controller.TransactionController;
import com.aliens.transaction.dto.TransactionDTO;
import com.aliens.transaction.entity.Transaction;
import com.aliens.transaction.service.TransactionService;
import com.aliens.transaction.serviceImpl.TransactionServiceImpl;

@ExtendWith(MockitoExtension.class)
class TransactionControllerTest {

	@Mock
	TransactionService serviceImpl;

	@InjectMocks
	TransactionController transactionController;

	
	List<Transaction> transactions;
	Transaction transaction;
	TransactionDTO transactionDTO;
	@BeforeEach
	void setUp() {
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
	void testGetBySenderAndDate() {
		String start="01-01-2021";
		String end="01-01-2021";
		when(serviceImpl.getByDateAndSender(1234L,start,end)).thenReturn(transactions);
		List<Transaction> found=transactionController.getBySenderAndDate(1234L, "01-01-2021","01-01-2021");
		assertEquals(transactions, found);
	}

	@Test
	void testSaveTransactionPositive() {
		when(serviceImpl.saveTransaction(transactionDTO)).thenReturn(true);
		String found=transactionController.saveTransaction(transactionDTO);
		assertEquals("Transaction Successful", found);
	}
	
	@Test
	void testSaveTransactionNegative() {
		when(serviceImpl.saveTransaction(transactionDTO)).thenReturn(false);
		String found=transactionController.saveTransaction(transactionDTO);
		assertEquals("Transaction Unsucessful", found);
	}

}
