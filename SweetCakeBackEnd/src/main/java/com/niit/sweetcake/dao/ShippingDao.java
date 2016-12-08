package com.niit.sweetcake.dao;

import java.util.List;

import com.niit.sweetcake.model.Shipping;


public interface ShippingDao {

	public boolean save(Shipping shipping);
	  public boolean delete(String shipping_Id);
	  public Shipping get(String shipping_Id);
	  public List<Shipping> list();
	  public boolean update(Shipping shipping);
}
