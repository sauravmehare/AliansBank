package com.aliens.account.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aliens.account.dto.BeneficiaryAccountDTO;
import com.aliens.account.entity.BeneficiaryAccount;
import com.aliens.transaction.entity.Transaction;

@Repository
public interface BeneficiaryAccountRepository extends JpaRepository<BeneficiaryAccount, Integer> {
	
	@Query("SELECT b FROM BeneficiaryAccount b WHERE b.senderAccNo = :senderAccountNo")
	List<BeneficiaryAccount> getAllbyAccountNo(@Param("senderAccountNo") Long senderAccountNo);
	
	@Query("SELECT b FROM BeneficiaryAccount b WHERE (b.senderAccNo = :sender AND b.receiverAccNo = :receiver)")
	List<BeneficiaryAccount> getBySenderAndReceiver(@Param("sender") Long sender,@Param("receiver") Long receiver);
}
