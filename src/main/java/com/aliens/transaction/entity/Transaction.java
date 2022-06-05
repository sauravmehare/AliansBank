package com.aliens.transaction.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long transaction;
	@NotNull(message ="Sender account number can not be empty")
	private Long senderAccNO;
	@NotNull(message ="Receiver account number can not be empty")
	private Long receiverAccNo;
	private Float amount;
	//private LocalDateTime dateTime;
	private LocalDate localDate;
	private LocalTime localTime;


	
	

	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	public LocalTime getLocalTime() {
		return localTime;
	}
	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}
	public Long getTransaction() {
		return transaction;
	}
	public void setTransaction(Long transaction) {
		this.transaction = transaction;
	}
	public Long getSenderAccNO() {
		return senderAccNO;
	}
	public void setSenderAccNO(Long senderAccNO) {
		this.senderAccNO = senderAccNO;
	}
	public Long getReceiverAccNo() {
		return receiverAccNo;
	}
	public void setReceiverAccNo(Long receiverAccNo) {
		this.receiverAccNo = receiverAccNo;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}


}
