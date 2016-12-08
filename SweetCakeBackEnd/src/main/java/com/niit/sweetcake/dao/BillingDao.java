package com.niit.sweetcake.dao;

import java.util.List;

import com.niit.sweetcake.model.Billing;

public interface BillingDao {

	public boolean save(Billing billing);
	  public boolean delete(String billing_Id);
	  public Billing get(String billing_Id);
	  public List<Billing> list();
	  public boolean update(Billing billing);
}
