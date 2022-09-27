package com.pbms.ProjectBackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pbms.ProjectBackend.entities.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {

	@Query(value = "SELECT max(CustID) FROM Customer")
	String getMaxCustomerId();
	
}
