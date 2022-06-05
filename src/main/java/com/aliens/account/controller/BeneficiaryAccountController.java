package com.aliens.account.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aliens.account.dto.BeneficiaryAccountDTO;
import com.aliens.account.entity.BeneficiaryAccount;
import com.aliens.account.service.BeneficiaryAccountService;

@RestController
public class BeneficiaryAccountController {
	
	@Autowired
	BeneficiaryAccountService beneficiaryAccountService;
	
	@PostMapping(value="/beneficiary")
	public ResponseEntity<String> addBebeficiaryAccount(@Valid @RequestBody BeneficiaryAccountDTO beneficiaryAccountDTO) {
		return new ResponseEntity<String> (beneficiaryAccountService.saveBeneficiaryAccount(beneficiaryAccountDTO),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/beneficiary/id/{benifId}")
	public ResponseEntity<String> deleteBebeficiaryAccount(@PathVariable("benifId") Integer benifId) {
		return new ResponseEntity<String> (beneficiaryAccountService.deleteBeneficiary(benifId),HttpStatus.OK);
	}
	
	
	@GetMapping(value="/beneficiary/sa/{senderAccountNo}/ra/{receiverAccountNO}")
	public ResponseEntity<List<BeneficiaryAccount>> getBySenderAndReceiver(@PathVariable("senderAccountNo") Long senderAccountNo,@PathVariable("receiverAccountNO") Long receiverAccountNO) {
		return new ResponseEntity<List<BeneficiaryAccount>> (beneficiaryAccountService.getBySenderAndReceiver(senderAccountNo, receiverAccountNO),HttpStatus.OK);
	}
	
	@GetMapping(value="/beneficiary/sa/{senderAccountNo}")
	public ResponseEntity<List<BeneficiaryAccount>> getAllbyAccountNo(@PathVariable("senderAccountNo") Long senderAccountNo) {
		return new ResponseEntity<List<BeneficiaryAccount>> (beneficiaryAccountService.getAllbyAccountNo(senderAccountNo),HttpStatus.OK);
	}

	
}
