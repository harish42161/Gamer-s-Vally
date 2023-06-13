package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int addr_id;
	
	@ManyToOne
	@JoinColumn(name ="area_id")
	Area area_id;

	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Area area_id) {
		super();
		this.area_id = area_id;
	}

	public int getAddr_id() {
		return addr_id;
	}

	public void setAddr_id(int addr_id) {
		this.addr_id = addr_id;
	}

	public Area getArea_id() {
		return area_id;
	}

	public void setArea_id(Area area_id) {
		this.area_id = area_id;
	}
	
	
}
