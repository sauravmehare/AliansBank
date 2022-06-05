package com.aliens.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aliens.customer.dto.CustomerContact;
import com.aliens.customer.dto.CustomerProjection;
import com.aliens.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	CustomerProjection findByName(String customerName);
	
	@Query("SELECT new com.aliens.customer.dto.CustomerContact(a.name, a.emailId) FROM Customer a WHERE a.emailId = :emailId")
	List<CustomerContact> findByEmailId(String emailId);

}
