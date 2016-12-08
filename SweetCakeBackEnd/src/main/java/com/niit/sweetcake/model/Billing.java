package com.niit.sweetcake.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Billing {
	
	@Id
	private String billing_Id;
	
	@OneToOne
	@JoinColumn(name="customer_Id")
	private Customer customer;
	
	
	private String b_address;
	
	public Billing() {
		this.billing_Id = "billing"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getBilling_Id() {
		return billing_Id;
	}

	public void setBilling_Id(String billing_Id) {
		this.billing_Id = billing_Id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getB_Address() {
		return b_address;
	}

	public void setB_Address(String b_address) {
		this.b_address = b_address;
	}

	
}
