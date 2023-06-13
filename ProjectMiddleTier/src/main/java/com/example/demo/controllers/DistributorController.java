package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AddOffer;
import com.example.demo.entities.Address;
import com.example.demo.entities.Area;
import com.example.demo.entities.Brand;
import com.example.demo.entities.Category;
import com.example.demo.entities.Distributor;
import com.example.demo.entities.DistributorReg;
import com.example.demo.entities.Login;
import com.example.demo.entities.Offer;
import com.example.demo.entities.PassBasedEnc;
import com.example.demo.entities.Product;
import com.example.demo.entities.Question;
import com.example.demo.entities.Role;
import com.example.demo.entities.SaltValue;
import com.example.demo.services.AddressService;
import com.example.demo.services.AreaService;
import com.example.demo.services.DistributorService;
import com.example.demo.services.LoginService;
import com.example.demo.services.OfferService;
import com.example.demo.services.ProductService;
import com.example.demo.services.QuestionService;
import com.example.demo.services.RoleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DistributorController {
	
	@Autowired
	DistributorService dservice;
	
	@Autowired
	LoginService lservice;
	
	@Autowired
	RoleService rservice;
	
	@Autowired
	AreaService aservice;
	
	@Autowired
	QuestionService qservice;
	
	@Autowired
	ProductService pservice;
	
	@Autowired
	OfferService oservice;
	
	@Autowired
	SaltValue saltValue;
	
	@Autowired
	AddressService addrservice;
	
	
	@GetMapping("/getDistributor")
	public Distributor getDistributor(@RequestParam("loginid") int loginid)
	{
		Login l = lservice.getById(loginid);
		return dservice.getDistributor(l); 
	}
	
	@PostMapping("/regDistributor")
	public Distributor regDistributor(@RequestBody DistributorReg dr)
	{
		Role r= rservice.getRole(5);
		System.out.println(saltValue.getSalt());
		String encrypted=PassBasedEnc.generateSecurePassword(dr.getPwd(), saltValue.getSalt());
		Question q=qservice.getQuestion(dr.getQuestion());
		
		Login l = new Login(dr.getEmail(),encrypted,r,q,dr.getAnswer(),false);
		Login saved= lservice.save(l);
		
		Area a=aservice.getById(dr.getArea_id());
		Address addr=addrservice.getAddressByArea(a);
		
		Distributor d=new Distributor(dr.getFname(),dr.getLname(),dr.getMobile(),addr,saved);
		return dservice.saveDistributor(d);
	}
	
	
	@PostMapping("/addOffers")
	public Offer addOffers(@RequestBody AddOffer ao)
	{
		Product prod = pservice.getById(ao.getProd_id());
		Offer offer=new Offer(ao.getDiscount(),prod,ao.getValidity());
		return oservice.saveOffer(offer);
	}

}