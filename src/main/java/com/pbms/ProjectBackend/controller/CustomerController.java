package com.pbms.ProjectBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbms.ProjectBackend.entities.Customer;
import com.pbms.ProjectBackend.services.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/")
	public List<Customer> getCustomers()
	{
		return customerService.getCustomers();
	}
	
	@GetMapping("/maxid")
	public int getMaxCustomerId()
	{
		return customerService.getMaxCustomerId();
	}
	
	@GetMapping("/{CustId}")
	public Customer getCustomer(@PathVariable int CustId)
	{
		return customerService.getCustomer(CustId);
	}
	
	@PostMapping("/")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		customer.setCustID(customerService.getMaxCustomerId()+1) ;
		return customerService.addCustomer(customer);
	}
	
	@PutMapping("/{CustId}")
	public void updateCustomer(@RequestBody Customer customer, @PathVariable int CustId)
	{
		customerService.updateCustomer(customer, CustId);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{CustId}")
	public void deleteCustomer(@PathVariable int CustId)
	{
		customerService.deleteCustomer(CustId);
	}
}
