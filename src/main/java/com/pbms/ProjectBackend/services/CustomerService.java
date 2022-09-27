package com.pbms.ProjectBackend.services;

import java.util.List;

import com.pbms.ProjectBackend.entities.Customer;

public interface CustomerService {
	
	public int getMaxCustomerId();
	
	public List<Customer> getCustomers();

	public Customer getCustomer(int CustId);

	public Customer addCustomer(Customer customer);

	public void updateCustomer(Customer customer, int CustId);

	public void deleteCustomer(int CustID);
	
	
}
