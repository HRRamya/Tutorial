package com.niit.sweetcake.dao;

import java.util.List;

import com.niit.sweetcake.model.Customer;

public interface CustomerDao {

	public boolean save(Customer customer);
	  public boolean delete(String customer_Id);
	  public Customer get(String userId);
	  public List<Customer> list();
	  public boolean update(Customer customer);
}
