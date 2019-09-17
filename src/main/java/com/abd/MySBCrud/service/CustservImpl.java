package com.abd.MySBCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abd.MySBCrud.dao.CustomerDao;
import com.abd.MySBCrud.entity.Customer;

@Service
public class CustservImpl implements CustomerServices {

	@Autowired
	private CustomerDao custdao;
	
	@Override
	@Transactional
	public List<Customer> GetCustomerfromservice() {
		// TODO Auto-generated method stub
		return custdao.GetCustomer();
	}

	@Override
	@Transactional
	public Customer findByIdfromservice(int theId) {
		// TODO Auto-generated method stub
		return custdao.findById(theId);
	}

	@Override
	@Transactional
	public void savefromservice(Customer theCustomer) {
		custdao.save(theCustomer);

	}

	@Override
	@Transactional
	public void DeleteByIdfromservice(int theId) {
		custdao.DeleteById(theId);

	}

}
