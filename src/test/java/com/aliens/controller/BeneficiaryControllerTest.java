package com.aliens.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;

import com.aliens.account.controller.BeneficiaryAccountController;
import com.aliens.account.dto.BeneficiaryAccountDTO;
import com.aliens.account.entity.BeneficiaryAccount;
import com.aliens.account.service.BeneficiaryAccountService;
import com.aliens.account.serviceImpl.BeneficiaryAccountServiceImpl;

@ExtendWith(MockitoExtension.class)
class BeneficiaryControllerTest {
	
	@Mock
	BeneficiaryAccountService beneficiaryAccountService;
	
	@InjectMocks
	BeneficiaryAccountController beneficiaryAccountController;
	
	BeneficiaryAccount beneficiaryAccount;
	BeneficiaryAccountDTO beneficiaryAccountDTO;
	List<BeneficiaryAccount> beneficiaryAccountList;
	@BeforeEach
	public void setUp(){
		beneficiaryAccountDTO=new BeneficiaryAccountDTO();
		beneficiaryAccountDTO.setReceiverAccNo(100L);
		beneficiaryAccountDTO.setSenderAccNo(101L);
		
		beneficiaryAccount=new BeneficiaryAccount();
		BeanUtils.copyProperties(beneficiaryAccountDTO, beneficiaryAccount);
		beneficiaryAccount.setBenifId(1);
		beneficiaryAccountList=new ArrayList<BeneficiaryAccount>();
		beneficiaryAccountList.add(beneficiaryAccount);
		
	}

	@Test
	void testAddBebeficiaryAccount() {
		when(beneficiaryAccountService.saveBeneficiaryAccount(beneficiaryAccountDTO)).thenReturn("Beneficiary Added.");
		ResponseEntity<String> found=beneficiaryAccountController.addBebeficiaryAccount(beneficiaryAccountDTO);
		assertEquals("Beneficiary Added.", found.getBody());
		assertEquals(found.getStatusCode(), found.getStatusCode());
	}

	@Test
	void testDeleteBebeficiaryAccount() {
		when(beneficiaryAccountService.deleteBeneficiary(1)).thenReturn("Beneficiary deleted.");
		ResponseEntity<String> found=beneficiaryAccountController.deleteBebeficiaryAccount(1);
		assertEquals("Beneficiary deleted.", found.getBody());
		assertEquals(found.getStatusCode(), found.getStatusCode());
	}

	@Test
	void testGetBySenderAndReceiver() {
		when(beneficiaryAccountService.getBySenderAndReceiver(100L, 101L)).thenReturn(beneficiaryAccountList);
		ResponseEntity<List<BeneficiaryAccount>> found=beneficiaryAccountController.getBySenderAndReceiver(100L, 101L);
		assertEquals(beneficiaryAccountList, found.getBody());
		assertEquals(found.getStatusCode(), found.getStatusCode());
	}
//
//	@Test
//	void testGetAllbyAccountNo() {
//		fail("Not yet implemented");
//	}

}
