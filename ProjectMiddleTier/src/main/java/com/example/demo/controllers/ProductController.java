package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController 
{
	@Autowired
	ProductService pservice;
	
	@GetMapping("/getProductById")
	public Product getProductById(@RequestParam("prod_id")int id)
	{
		return pservice.getById(id);
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts()
	{
		return pservice.getAllProducts();
	}
	
	@GetMapping("/getAllMonitors")
	public List<Product> getAllMonitors()
	{
		return pservice.getAllMonitors();
	}
	
	@GetMapping("/getAllKeyboards")
	public List<Product> getAllKeyboards()
	{
		return pservice.getAllKeyboards();
	}
	
	@GetMapping("/getAllCabinets")
	public List<Product> getAllCabinets()
	{
		return pservice.getAllCabinets();
	}
	
	@GetMapping("/getAllMotherboards")
	public List<Product> getAllMotherboards()
	{
		return pservice.getAllMotherboards();
	}
	
	@GetMapping("/getAllStorage")
	public List<Product> getAllStorage()
	{
		return pservice.getAllStorage();
	}
	
	@GetMapping("/getAllMouse")
	public List<Product> getAllMouse()
	{
		return pservice.getAllMouse();
	}
	
	@GetMapping("/getAllGraphics_card")
	public List<Product> getAllGraphics_card()
	{
		return pservice.getAllGraphics_card();
	}
	
	@GetMapping("/getAllGaming_chairs")
	public List<Product> getAllGaming_chairs()
	{
		return pservice.getAllGaming_chairs();
	}
}
