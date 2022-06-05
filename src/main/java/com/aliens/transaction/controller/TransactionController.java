package com.aliens.transaction.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aliens.transaction.dto.TransactionDTO;
import com.aliens.transaction.entity.Transaction;
import com.aliens.transaction.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	protected final static Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	//Saving Transaction
	@PostMapping("/transaction")
	public String saveTransaction(@RequestBody TransactionDTO transaction) {
		logger.info("Data is being saved");
		boolean msg=transactionService.saveTransaction(transaction);
		if(msg==true) {
			return "Transaction Successful";
		}
		else {
			return "Transaction Unsucessful";
		}
	}
	
	//Fetching Transactions
	@GetMapping(value = "/transaction/acc/{senderAccNO}/sd/{startDate}/ed/{endDate}")
	public List<Transaction> getBySenderAndDate(@PathVariable("senderAccNO") Long senderAccNO,@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate){
		
		logger.info("Data is being fetched");
		return (List<Transaction>) transactionService.getByDateAndSender(senderAccNO, startDate, endDate);
	}

}
