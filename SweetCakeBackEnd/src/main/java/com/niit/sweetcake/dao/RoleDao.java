package com.niit.sweetcake.dao;

import java.util.List;

import com.niit.sweetcake.model.Role;

public interface RoleDao {
	public boolean save(Role role);
	  public boolean delete(String role_Id);
	  public Role get(String role_Id);
	  public List<Role> list();

}
