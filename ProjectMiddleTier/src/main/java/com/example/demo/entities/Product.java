package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int prod_id;
	
	@ManyToOne
	@JoinColumn(name="cat_id")
	Category cat_id;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	Brand brand_id;
	
	String description;
	
	double price;
	
	byte[] picture;
	
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Product(Category cat_id, Brand brand_id, String description, double price) {
		super();
		this.cat_id = cat_id;
		this.brand_id = brand_id;
		this.description = description;
		this.price = price;
	}


	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public Category getCat_id() {
		return cat_id;
	}

	public void setCat_id(Category cat_id) {
		this.cat_id = cat_id;
	}

	public Brand getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Brand brand_id) {
		this.brand_id = brand_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	
}
