package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="prebuilt_pc")
public class Prebuilt_pc 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pc_id;
	
	@ManyToOne
	@JoinColumn(name ="exp_id")
	Expert exp_id;
	
	String monitor,keyboard,cabinet,motherboard,ssd,mouse,gr_card;
	
	double total_price;
	
	

	public Prebuilt_pc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Prebuilt_pc(Expert exp_id, String monitor, String keyboard, String cabinet, String motherboard,
			String ssd, String mouse, String gr_card, double total_price) {
		super();
		this.exp_id = exp_id;
		this.monitor = monitor;
		this.keyboard = keyboard;
		this.cabinet = cabinet;
		this.motherboard = motherboard;
		this.ssd = ssd;
		this.mouse = mouse;
		this.gr_card = gr_card;
		this.total_price = total_price;
	}



	public Prebuilt_pc(Expert exp_id) {
		super();
		this.exp_id = exp_id;
	}



	public int getPc_id() {
		return pc_id;
	}

	public void setPc_id(int pc_id) {
		this.pc_id = pc_id;
	}

	public Expert getExp_id() {
		return exp_id;
	}

	public void setExp_id(Expert exp_id) {
		this.exp_id = exp_id;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}

	public String getCabinet() {
		return cabinet;
	}

	public void setCabinet(String cabinet) {
		this.cabinet = cabinet;
	}

	public String getMotherboard() {
		return motherboard;
	}

	public void setMotherboard(String motherboard) {
		this.motherboard = motherboard;
	}

	public String getSsd() {
		return ssd;
	}

	public void setSsd(String ssd) {
		this.ssd = ssd;
	}

	public String getMouse() {
		return mouse;
	}

	public void setMouse(String mouse) {
		this.mouse = mouse;
	}

	public String getGr_card() {
		return gr_card;
	}

	public void setGr_card(String gr_card) {
		this.gr_card = gr_card;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	
	
	
	
	
}
