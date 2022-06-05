package com.aliens.transaction.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.aliens.transaction.dto.TransactionDTO;
import com.aliens.transaction.entity.Transaction;

public interface TransactionService {
	
	boolean saveTransaction(TransactionDTO transaction);
	
	List<Transaction> getByDateAndSender(@Param("senderAccNO")Long senderAccNO,@Param("startDateTime") String startDateTime,@Param("endDateTime") String endDateTime);

}
