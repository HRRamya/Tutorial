package com.niit.sweetcake.dao;

import java.util.List;

import com.niit.sweetcake.model.Orders;

public interface OrderDao {

	public boolean saveorupdate(Orders orders);
	  public boolean delete(String userid);
	  public Orders get(String userid);
	  public List<Orders> list();
	  
}
