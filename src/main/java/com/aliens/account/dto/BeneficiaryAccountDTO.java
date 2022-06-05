package com.aliens.account.dto;

import javax.validation.constraints.NotNull;

public class BeneficiaryAccountDTO {
	@NotNull(message ="Sender account number can not be empty")
	private Long senderAccNo;
	@NotNull(message ="Receiver account number can not be empty")
	private Long receiverAccNo;
	
	
	public Long getSenderAccNo() {
		return senderAccNo;
	}
	public void setSenderAccNo(Long senderAccNo) {
		this.senderAccNo = senderAccNo;
	}
	public Long getReceiverAccNo() {
		return receiverAccNo;
	}
	public void setReceiverAccNo(Long receiverAccNo) {
		this.receiverAccNo = receiverAccNo;
	}

}
