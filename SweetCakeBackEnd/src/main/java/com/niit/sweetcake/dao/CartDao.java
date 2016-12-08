package com.niit.sweetcake.dao;

import java.util.List;

import com.niit.sweetcake.model.Cart;

public interface CartDao {

      public boolean saveorupdate(Cart cart);
	  public boolean delete(String cart_Id);
	  public Cart get(String userId);
	  public List<Cart> list();
}
