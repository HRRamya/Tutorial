package com.niit.sweetcake.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class CartItems {

	@Id
	private String cartitems_Id;

	@ManyToOne
	@JoinColumn(name = "cart_Id")
	private Cart cart;

	private String userId;

	private String P_Id;
	
	private String P_Name;

	private int quantity;

	private double totalprice;

	public CartItems() {
		this.cartitems_Id = "cartitems_Id" + UUID.randomUUID().toString().substring(30).toLowerCase();

	}

	public String getCartitems_Id() {
		return cartitems_Id;
	}

	public void setCartitems_Id(String cartitems_Id) {
		this.cartitems_Id = cartitems_Id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getP_Id() {
		return P_Id;
	}

	public void setP_Id(String p_Id) {
		P_Id = p_Id;
	}

	public String getP_Name() {
		return P_Name;
	}

	public void setP_Name(String p_Name) {
		P_Name = p_Name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

}
