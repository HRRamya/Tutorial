package com.niit.sweetcake.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Shipping {

	@Id
	private String shipping_Id;
	
	@ManyToOne
	@JoinColumn(name="customer_Id")
	private Customer customer;
	
	private String s_address;

	public Shipping() {
		this.shipping_Id = "shipping"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getShipping_Id() {
		return shipping_Id;
	}

	public void setShipping_Id(String shipping_Id) {
		this.shipping_Id = shipping_Id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getS_Address() {
		return s_address;
	}

	public void setS_Address(String s_address) {
		this.s_address = s_address;
	}
	
	
	
	
}
