package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int login_id;
	String email;
	String pwd;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	Role role_id;
	
	@ManyToOne
	@JoinColumn(name="q_id")
	Question q_id;
	String answer;
	boolean status;
	
	public Login() {
		super();
		
	}
	public Login(String email, String pwd, Role role_id, Question q_id, String answer, boolean status) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.role_id = role_id;
		this.q_id = q_id;
		this.answer = answer;
		this.status = status;
	}
	
	
	
	public Login(String email, String pwd, Role role_id, boolean status) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.role_id = role_id;
		this.status = status;
	}
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Role getRole_id() {
		return role_id;
	}
	public void setRole_id(Role role_id) {
		this.role_id = role_id;
	}
	public Question getQ_id() {
		return q_id;
	}
	public void setQ_id(Question q_id) {
		this.q_id = q_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	

}
