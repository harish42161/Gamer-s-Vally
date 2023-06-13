package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reuirement")
public class Requirement 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int req_id;
	
	@OneToOne
	@JoinColumn(name ="cust_id")
	Customer cust_id;
	
	@OneToOne
	@JoinColumn(name ="exp_id")
	Expert exp_id;
	
	double min_price;
	
	double max_price;
	
	String specifications;

	
	
	public Requirement() {
		super();
	}
	
	

	public Requirement(Customer cust_id, Expert exp_id, double min_price, double max_price,String specifications) {
		super();
		this.cust_id = cust_id;
		this.exp_id = exp_id;
		this.min_price = min_price;
		this.max_price = max_price;
		this.specifications = specifications;
	}



	public int getReq_id() {
		return req_id;
	}

	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}

	public Customer getCust_id() {
		return cust_id;
	}

	public void setCust_id(Customer cust_id) {
		this.cust_id = cust_id;
	}

	public Expert getExp_id() {
		return exp_id;
	}

	public void setExp_id(Expert exp_id) {
		this.exp_id = exp_id;
	}

	public double getMin_price() {
		return min_price;
	}

	public void setMin_price(double min_price) {
		this.min_price = min_price;
	}

	public double getMax_price() {
		return max_price;
	}

	public void setMax_price(double max_price) {
		this.max_price = max_price;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	
	
	
	
}
