package com.niit.sweetcake.dao;

import java.util.List;

import com.niit.sweetcake.model.User;

public interface UserDao {

	public boolean saveorupdate(User user);
	public boolean delete(String userId);
	public User get(String userId);
	   public List<User> list();
	   public User isvalidate(String emailId,String password);
		public User getByEmailId(String emailId);
}
