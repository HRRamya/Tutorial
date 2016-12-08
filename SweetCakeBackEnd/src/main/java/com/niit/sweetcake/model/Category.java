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
public class Category {
	
	@Id
	private String c_Id;

	private String c_Name;

	private String c_Description;
	
	
	@OneToMany(mappedBy="category")
	List<Product> product;
	
	public Category()
	{
		this.c_Id = "category"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getC_Id() {
		return c_Id;
	}

	public void setC_Id(String c_Id) {
		this.c_Id = c_Id;
	}

	public String getC_Name() {
		return c_Name;
	}

	public void setC_Name(String c_Name) {
		this.c_Name = c_Name;
	}

	public String getC_Description() {
		return c_Description;
	}

	public void setC_Description(String c_Description) {
		this.c_Description = c_Description;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	

}
