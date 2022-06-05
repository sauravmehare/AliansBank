package com.aliens.account.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class BeneficiaryAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer benifId;
	@NotNull(message ="Sender account number can not be empty")
	private Long senderAccNo;
	@NotNull(message ="Receiver account number can not be empty")
	private Long receiverAccNo;
	
	public BeneficiaryAccount() {
		
	}
	
	
	public BeneficiaryAccount(Integer benifId, Long senderAccNo, Long receiverAccNo) {
		this.benifId = benifId;
		this.senderAccNo = senderAccNo;
		this.receiverAccNo = receiverAccNo;
	}
	public Integer getBenifId() {
		return benifId;
	}
	public void setBenifId(Integer benifId) {
		this.benifId = benifId;
	}
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
