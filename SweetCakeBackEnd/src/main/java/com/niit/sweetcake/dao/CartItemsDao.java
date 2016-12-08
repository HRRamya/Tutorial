package com.niit.sweetcake.dao;

import java.util.List;

import com.niit.sweetcake.model.CartItems;

public interface CartItemsDao {

	public boolean save(CartItems cartitems);
	  public boolean delete(CartItems cartItems);
	  public List<CartItems> get(String cart_Id);
	  public CartItems getbyCartItems(String id);
	  public boolean prodelete(CartItems cartItems);
	  public List<CartItems> list();
}
