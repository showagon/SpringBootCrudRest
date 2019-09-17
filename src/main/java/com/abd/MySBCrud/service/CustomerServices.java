package com.abd.MySBCrud.service;

import java.util.List;

import com.abd.MySBCrud.entity.Customer;

public interface CustomerServices {

	public List<Customer> GetCustomerfromservice();
	public Customer findByIdfromservice(int theId);
	public void savefromservice(Customer theCustomer);
	public void DeleteByIdfromservice(int theId);
	
	
}
