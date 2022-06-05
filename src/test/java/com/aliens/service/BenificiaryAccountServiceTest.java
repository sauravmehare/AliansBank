package com.aliens.service;

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

import com.aliens.account.dto.BeneficiaryAccountDTO;
import com.aliens.account.entity.BeneficiaryAccount;
import com.aliens.account.repository.BeneficiaryAccountRepository;
import com.aliens.account.serviceImpl.BeneficiaryAccountServiceImpl;

@ExtendWith(MockitoExtension.class)
class BenificiaryAccountServiceTest {
	
	@Mock
	BeneficiaryAccountRepository beneficiaryAccountRepository;
	
	@InjectMocks
	BeneficiaryAccountServiceImpl beneficiaryAccountServiceImpl;
	
	List<BeneficiaryAccount> beneficiaryAccounts;
	BeneficiaryAccountDTO beneficiaryAccountDTO;
	
	@BeforeEach
	public void setUp(){
		beneficiaryAccounts=new ArrayList<BeneficiaryAccount>();
		BeneficiaryAccount acc1=new BeneficiaryAccount(1, 111L, 112L);
		beneficiaryAccounts.add(acc1);
	}
	
	@Test
	void testGetAllbyAccountNo() {
		when(beneficiaryAccountRepository.getAllbyAccountNo(111L)).thenReturn(beneficiaryAccounts);
		List<BeneficiaryAccount> found=beneficiaryAccountServiceImpl.getAllbyAccountNo(111L);
		assertEquals(beneficiaryAccounts, found);
	}
	
	@Test
	void testGetBySenderAndReceiver() {
		when(beneficiaryAccountRepository.getBySenderAndReceiver(111L, 112L)).thenReturn(beneficiaryAccounts);
		List<BeneficiaryAccount> found=beneficiaryAccountServiceImpl.getBySenderAndReceiver(111L, 112L);
		assertEquals(beneficiaryAccounts, found);
	}
 
//	@Test
//	void testSaveBeneficiaryAccount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteBeneficiary() {
//		beneficiaryAccountServiceImpl.deleteBeneficiary(1);
//	}
//
	
}
