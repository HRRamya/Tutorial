package com.niit.sweetcake.dao;

import java.util.List;

import com.niit.sweetcake.model.Category;

public interface CategoryDao {

	 public boolean saveorupdate(Category category);
	  public boolean delete(String c_Id);
	  public Category get(String c_Id);
	  public List<Category> list();
	  public boolean update(Category category);
	  
	}

