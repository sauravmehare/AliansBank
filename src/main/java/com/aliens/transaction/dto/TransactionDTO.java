package com.aliens.transaction.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TransactionDTO {
	
	@NotNull(message ="Sender account number can not be empty")
	private Long senderAccNO;
	@NotNull(message ="Receiver account number can not be empty")
	private Long receiverAccNo;
	@Min(value=1)
	private Float amount;
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
