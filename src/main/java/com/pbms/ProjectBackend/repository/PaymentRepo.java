package com.pbms.ProjectBackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pbms.ProjectBackend.entities.Payment;

public interface PaymentRepo extends CrudRepository<Payment, Integer> {

	@Query(value = "SELECT max(PayID) FROM Payment")
	String getMaxPaymentId();
	
	@Query(value = "SELECT cname FROM Payment where bookid=? limit 1", nativeQuery = true)
	String checkBookIdInPayment(int bookid);
	
	@Query(value = "select max(amount_paid) from payment where bookid =?", nativeQuery = true)
	long getAmountPaid(int BookID);
}
