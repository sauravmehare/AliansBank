package com.aliens.transaction.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aliens.transaction.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query("SELECT t FROM Transaction t WHERE (t.localDate BETWEEN :startDateTime AND :endDateTime) AND (t.senderAccNO = :senderAccNO)")
	List<Transaction> getByDateAndSender(@Param("senderAccNO") Long senderAccNO,@Param("startDateTime") LocalDate startDateTime,@Param("endDateTime") LocalDate endDateTime);
	
	//Transaction findbydateTime(LocalDateTime localDateTime);
}
