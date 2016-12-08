package com.niit.sweetcake.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {

	@Id
	private String cart_Id;
	
	private String userId;

	private String grandtotal;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartItems> cartItems;

	public Cart() {
		this.cart_Id = "cart_Id" + UUID.randomUUID().toString().substring(30).toLowerCase();
	}

	public String getCart_Id() {
		return cart_Id;
	}

	public void setCart_Id(String cart_Id) {
		this.cart_Id = cart_Id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(String grandtotal) {
		this.grandtotal = grandtotal;
	}

	public List<CartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}

}
