package com.abd.MySBCrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.abd.MySBCrud.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<Customer> GetCustomer(){
		
		Session cursession = entityManager.unwrap(Session.class);
		Query<Customer> theQuery = cursession.createQuery("from Customer",Customer.class);
		List<Customer> theCustomer = theQuery.getResultList();
		return theCustomer;
	}

	@Override
	public Customer findById(int theId) {
		Session cursession = entityManager.unwrap(Session.class);
		Customer theCustomer = cursession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {
		Session cursession = entityManager.unwrap(Session.class);
		//If Id=0 then It will do insert or id=x then it will do update
		cursession.saveOrUpdate(theCustomer);
	}

	@Override
	public void DeleteById(int theId) {
		Session cursession = entityManager.unwrap(Session.class);
	Query thequery =	cursession.createQuery("delete from Customer where id=:empid");
	thequery.setParameter("empid", theId);	
	thequery.executeUpdate();
	}

}
