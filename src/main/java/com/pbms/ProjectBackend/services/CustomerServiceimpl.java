package com.pbms.ProjectBackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbms.ProjectBackend.entities.Customer;
import com.pbms.ProjectBackend.exceptions.ResourceNotFoundException;
import com.pbms.ProjectBackend.repository.CustomerRepo;

@Service
public class CustomerServiceimpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	public CustomerServiceimpl(CustomerRepo customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers =  (List<Customer>) customerRepo.findAll();
		return customers;
	}

	@Override
	public Customer getCustomer(int CustID) {
		Customer customer = customerRepo.findById(CustID).orElseThrow(()-> new ResourceNotFoundException("Customer", "id", CustID));
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Customer cust=customerRepo.save(customer);
		return cust;
	}

	@Override
	public void updateCustomer(Customer customer, int CustId) {
		customer.setCustID(CustId);
		customerRepo.save(customer);
	}

	@Override
	public void deleteCustomer(int CustID) {
		customerRepo.deleteById(CustID);
	}

	@Override
	public int getMaxCustomerId() {
		
		if ((customerRepo.getMaxCustomerId())== null) {
			return 0;
		}
		else {
			return Integer.parseInt(customerRepo.getMaxCustomerId());
		}
		
	}
	
	

	

}
