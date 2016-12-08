package com.niit.sweetcake.dao;

import java.util.List;

import com.niit.sweetcake.model.Supplier;

public interface SupplierDao {

	 public boolean saveorupdate(Supplier supplier);
	  public boolean delete(String s_Id);
	  public Supplier get(String s_Id);
	  public List<Supplier> list();
	  void edit(Supplier supplier);
}
