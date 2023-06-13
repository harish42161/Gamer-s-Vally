package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Address;
import com.example.demo.entities.Area;
import com.example.demo.entities.Customer;
import com.example.demo.entities.CustomerReg;
import com.example.demo.entities.Expert;
import com.example.demo.entities.Login;
import com.example.demo.entities.PassBasedEnc;
import com.example.demo.entities.Question;
import com.example.demo.entities.Requirement;
import com.example.demo.entities.Role;
import com.example.demo.entities.SaltValue;
import com.example.demo.services.AddressService;
import com.example.demo.services.AreaService;
import com.example.demo.services.CustomerService;
import com.example.demo.services.ExpertService;
import com.example.demo.services.LoginService;
import com.example.demo.services.QuestionService;
import com.example.demo.services.RequirementService;
import com.example.demo.services.RoleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController 
{
	@Autowired
	AreaService aservice;
	
	@Autowired
	CustomerService cservice;
	
	@Autowired
	LoginService lservice;
	
	@Autowired
	RoleService rservice;
	
	@Autowired
	AddressService addrservice;
	
	@Autowired
	ExpertService expservice;
	
	@Autowired
	RequirementService reqservice;
	
	@Autowired
	QuestionService qservice;
	
	@Autowired
	SaltValue saltValue;
	
	@GetMapping("/getCustomer")
	public Customer getCustomer(@RequestParam("loginid") int loginid)
	{
		Login l = lservice.getById(loginid);
		return cservice.getCustomer(l); 

	}
	
	@GetMapping("/viewAllExperts")
	public List<Expert> viewAllExperts()
	{
		return expservice.viewAllExperts(); 

	}
	
	@GetMapping("/sendRequirement")
	public Requirement sendRequirement(@RequestParam("cust_id")int cust_id,@RequestParam("exp_id")int exp_id,@RequestParam("max_range")double max_range)
	{
		Customer c=cservice.getById(cust_id);
		Expert e=expservice.getById(exp_id);
		Requirement r=new Requirement(c,e,0.00,max_range,"Gaming");
		return reqservice.sendRequirement(r);
	}
	
	@PostMapping("/regCustomer")
	public Customer regCustomer(@RequestBody CustomerReg cs)
	{
		Role r= rservice.getRole(2);
		System.out.println(saltValue.getSalt());
		String encrypted=PassBasedEnc.generateSecurePassword(cs.getPwd(), saltValue.getSalt());
		Question q=qservice.getQuestion(cs.getQuestion());
		
		Login l = new Login(cs.getEmail(),encrypted,r,q,cs.getAnswer(),true);
		Login saved= lservice.save(l);
		
		Area a=aservice.getById(cs.getArea_id());
		Address addr=addrservice.getAddressByArea(a);
		
		Customer c=new Customer(cs.getFname(),cs.getLname(),cs.getMobile(),cs.getBdate(),addr,saved);
		return cservice.saveCustomer(c);
	}
	
}
