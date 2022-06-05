package com.aliens.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aliens.account.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	@Query("SELECT a FROM Account a WHERE a.id = :custId")
	Account findByCustId(Long custId);

}
