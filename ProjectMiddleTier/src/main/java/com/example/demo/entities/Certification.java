package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="certification")
public class Certification 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cert_id;
	
	String certification_name;

	public int getCert_id() {
		return cert_id;
	}

	public void setCert_id(int cert_id) {
		this.cert_id = cert_id;
	}

	public String getCertification_name() {
		return certification_name;
	}

	public void setCertification_name(String certification_name) {
		this.certification_name = certification_name;
	}
	
	
	
}
