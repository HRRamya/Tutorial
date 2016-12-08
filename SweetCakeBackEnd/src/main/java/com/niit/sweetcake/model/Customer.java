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
public class Customer {
	@Id
	
	private String customer_Id;
	
	private String customer_Name; 
	
	private String customer_mobile;
	
	private String customer_Emailid;
	
	@OneToOne
	@JoinColumn(name="billing_Id")
	private Billing billing;

	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	private List<Shipping> shipping_Id;

	private String userId;
	
	@OneToOne
	@JoinColumn(name="cart_Id")
//	@OneToOne(mappedBy="cart_Id",cascade=CascadeType.ALL)
	private Cart cart;
	
	
	public Customer() {
		this.customer_Id = "customer"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(String customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	
	public String getCustomer_mobile() {
		return customer_mobile;
	}

	public void setCustomer_mobile(String customer_mobile) {
		this.customer_mobile = customer_mobile;
	}

	public String getCustomer_Emailid() {
		return customer_Emailid;
	}

	public void setCustomer_Emailid(String customer_Emailid) {
		this.customer_Emailid = customer_Emailid;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public List<Shipping> getShipping_Id() {
		return shipping_Id;
	}

	public void setShipping_Id(List<Shipping> shipping_Id) {
		this.shipping_Id = shipping_Id;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	
	
}
