package com.abd.MySBCrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.abd.MySBCrud.entity.Customer;
import com.abd.MySBCrud.service.CustomerServices;

@RestController
public class CusResCont {
	
@Autowired
private CustomerServices custservice;
	
	@GetMapping("/customer")
	public List<Customer> CustomerList(){
		return custservice.GetCustomerfromservice();
		
		
	}
	
	
	@GetMapping("/customer/{custid}")
	public Customer SingleCustomer(@PathVariable int custid){
		Customer thecust =  custservice.findByIdfromservice(custid);
		
		if(thecust==null) {
		 
		throw new RuntimeException("The given Id not found");
	}
		
		return thecust;
	}
	
	@PostMapping("/Inscustomer")
	public Customer InsertCustomer(@RequestBody Customer theCustomer){
		
		
		theCustomer.setId(0);
		custservice.savefromservice(theCustomer);
		return theCustomer;
	}
	
	@PutMapping("/updcustomer")
	public Customer updateCustomer(@RequestBody Customer theCustomer){
		
		
		
		custservice.savefromservice(theCustomer);
		return theCustomer;
	}
	
	@DeleteMapping("/delcustomer/{custid}")
	public String deleteCustomer(@PathVariable int custid){
		
		Customer thecust = custservice.findByIdfromservice(custid);
		
		if(thecust==null) {
			 
			throw new RuntimeException("The given Id not found");
		}
		custservice.DeleteByIdfromservice(custid);
			return "Customer Deleted Successfully";
	}
	
	
}
