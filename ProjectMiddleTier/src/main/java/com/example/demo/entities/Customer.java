package com.example.demo.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cust_id;
	
	String fname;
	
	String lname;
	
	String mobile;
	@OneToOne
	@JoinColumn(name ="addr_id")
	Address addr_id;
	
	@OneToOne
	@JoinColumn(name ="login_id")
	Login login_id;
	
    Date bdate;
	
	int user_status;
	
	
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String fname, String lname, String mobile,Date bdate,Address addr_id, Login login_id) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.mobile = mobile;
		this.bdate = bdate;
		this.addr_id = addr_id;
		this.login_id = login_id;
	}


	public Login getLogin_id() {
		return login_id;
	}


	public void setLogin_id(Login login_id) {
		this.login_id = login_id;
	}


	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
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

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public int getUser_status() {
		return user_status;
	}

	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}

	
	
	
	

}
