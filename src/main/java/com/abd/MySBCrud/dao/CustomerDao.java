package com.abd.MySBCrud.dao;

import java.util.List;

import com.abd.MySBCrud.entity.Customer;

public interface CustomerDao {

	public List<Customer> GetCustomer();
	public Customer findById(int theId);
	public void save(Customer theCustomer);
	public void DeleteById(int theId);
	
	
}
