package com.example.demo.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "expert")
public class Expert 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int exp_id;
	String fname;
	String lname;
	String mobile;
	
	@OneToOne
	@JoinColumn(name ="login_id")
	Login login_id;
	int certification;
	int experience;
	byte[] picture;
	
	
	
	public Expert() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Expert(String fname, String lname, String mobile, Login login_id, int certification, int experience) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.mobile = mobile;
		this.login_id = login_id;
		this.certification = certification;
		this.experience = experience;
	}

	
	public Login getLogin_id() {
		return login_id;
	}

	public void setLogin_id(Login login_id) {
		this.login_id = login_id;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public int getExp_id() {
		return exp_id;
	}
	public void setExp_id(int exp_id) {
		this.exp_id = exp_id;
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
	public int getCertification() {
		return certification;
	}
	public void setCertification(int cerification) {
		this.certification = cerification;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	

}
