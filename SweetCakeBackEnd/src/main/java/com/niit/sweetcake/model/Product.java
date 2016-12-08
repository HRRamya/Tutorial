package com.niit.sweetcake.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Table
@Entity
@Component
public class Product {

	@Id
	private String p_Id;
	
	private String p_Name;
	
	private String p_Description;
	
	private double p_Price;
	
	private int p_Quantity;
	
	private String image;
	@Transient
	private MultipartFile img;
		
	@ManyToOne
	@JoinColumn(name="c_Id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="s_Id")
	private Supplier supplier;
	
	public Product()
	{
		this.p_Id = "product"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
		
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
		
		
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public String getP_Id() {
		return p_Id;
	}


	public void setP_Id(String p_Id) {
		this.p_Id = p_Id;
	}


	public String getP_Name() {
		return p_Name;
	}


	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}


	public String getP_Description() {
		return p_Description;
	}


	public void setP_Description(String p_Description) {
		this.p_Description = p_Description;
	}


	public double getP_Price() {
		return p_Price;
	}


	public void setP_Price(double p_Price) {
		this.p_Price = p_Price;
	}


	public int getP_Quantity() {
		return p_Quantity;
	}


	public void setP_Quantity(int p_Quantity) {
		this.p_Quantity = p_Quantity;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public MultipartFile getImg() {
		return img;
	}


	public void setImg(MultipartFile img) {
		this.img = img;
	}


	
	
	
}