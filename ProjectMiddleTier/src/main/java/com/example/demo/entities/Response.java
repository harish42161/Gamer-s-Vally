package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="response")
public class Response 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int res_id;
	
	@OneToOne
	@JoinColumn(name="req_id")
	Requirement req_id;
	
	@OneToOne
	@JoinColumn(name="pc_id")
	Prebuilt_pc pc_id;
	
	

	public Response() {
		super();
	}
	
	

	public Response(Requirement req_id, Prebuilt_pc pc_id) {
		super();
		this.req_id = req_id;
		this.pc_id = pc_id;
	}



	public int getRes_id() {
		return res_id;
	}

	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}

	public Requirement getReq_id() {
		return req_id;
	}

	public void setReq_id(Requirement req_id) {
		this.req_id = req_id;
	}

	public Prebuilt_pc getPc_id() {
		return pc_id;
	}

	public void setPc_id(Prebuilt_pc pc_id) {
		this.pc_id = pc_id;
	}
	
	
}
