package com.niit.sweetcake.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table 
@Component
public class Supplier {

	@Id
	private String s_Id;
	
	private String s_Name;
	
	private String s_Address;
	
	private String s_Phoneno;
	
	@OneToMany(mappedBy="supplier")
	List<Product> product;

	public Supplier()
	{
		this.s_Id = "supplier"+UUID.randomUUID().toString().substring(34).toUpperCase();
	}
	
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public String getS_Id() {
		return s_Id;
	}

	public void setS_Id(String s_Id) {
		this.s_Id = s_Id;
	}

	public String getS_Name() {
		return s_Name;
	}

	public void setS_Name(String s_Name) {
		this.s_Name = s_Name;
	}

	public String getS_Address() {
		return s_Address;
	}

	public void setS_Address(String s_Address) {
		this.s_Address = s_Address;
	}

	public String getS_Phoneno() {
		return s_Phoneno;
	}

	public void setS_Phoneno(String s_Phoneno) {
		this.s_Phoneno = s_Phoneno;
	}

	
	
		
}
