package com.aliens.account.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AccountDTO {
	@NotNull(message ="Account number can not be empty")
	private Long accountNo;
	@NotNull(message ="Customer id number can not be empty")
	private Integer id;
	@NotNull(message = "Balance number can not be blank")
	@Min(value=1000,message = "Balance should be greater than 1000")
	private Float balance;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}


}
