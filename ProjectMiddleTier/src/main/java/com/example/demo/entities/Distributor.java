package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="distributor")
public class Distributor {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int distri_id;
	String fname;
	String lname;
	String mobile;
	
	@OneToOne
	@JoinColumn(name ="login_id")
	Login login_id;
	
	
	@OneToOne
	@JoinColumn(name ="addr_id")
	Address addr_id;
	
	
	
	public Distributor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Distributor( String fname, String lname, String mobile,Address addr_id, Login login_id) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.mobile = mobile;
		this.addr_id=addr_id;
		this.login_id = login_id;
		
	}

	
	public Distributor(Address addr_id) {
		super();
		this.addr_id = addr_id;
	}

	public Login getLogin_id() {
		return login_id;
	}

	public void setLogin_id(Login login_id) {
		this.login_id = login_id;
	}

	public int getDistri_id() {
		return distri_id;
	}
	public void setDistri_id(int ditri_id) {
		this.distri_id = ditri_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Address getAddr_id() {
		return addr_id;
	}
	public void setAddr_id(Address addr_id) {
		this.addr_id = addr_id;
	}
	
	

}
