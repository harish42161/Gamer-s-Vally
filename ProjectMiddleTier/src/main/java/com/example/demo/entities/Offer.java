package com.example.demo.entities;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="offer")
public class Offer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int offer_id;
	
	double discount;
	
	@ManyToOne
	@JoinColumn(name="prod_id")
	Product prod_id;
	
	Date validity;
	
	
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Offer(double discount, Product prod_id, Date validity) {
		super();
		this.discount = discount;
		this.prod_id = prod_id;
		this.validity = validity;
	}


	public int getOffer_id() {
		return offer_id;
	}
	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Product getProd_id() {
		return prod_id;
	}
	public void setProd_id(Product prod_id) {
		this.prod_id = prod_id;
	}
	public Date getValidity() {
		return validity;
	}
	public void setValidity(Date validity) {
		this.validity = validity;
	}
	
	
	
	

}
