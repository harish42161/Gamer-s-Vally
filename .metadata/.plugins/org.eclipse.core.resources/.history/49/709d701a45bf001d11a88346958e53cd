package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	ProductRepository prepo;
	
	
	public Product saveProduct(Product p)
	{
		return prepo.save(p);
	}
	
	public List<Product> getAllProducts()
	{
		return prepo.findAll();
	}
	
	public List<Product> getAllMonitors()
	{
		return prepo.getAllMonitors();
	}
	
	public List<Product> getAllKeyboards()
	{
		return prepo.getAllKeyboards();
	}
	
	public List<Product> getAllCabinets()
	{
		return prepo.getAllCabinets();
	}
	
	public List<Product> getAllMotherboards()
	{
		return prepo.getAllMotherboards();
	}
	
	public List<Product> getAllStorage()
	{
		return prepo.getAllStorage();
	}
	
	public List<Product> getAllMouse()
	{
		return prepo.getAllMouse();
	}
	
	public List<Product> getAllGraphics_card()
	{
		return prepo.getAllGraphics_card();
	}
	
	public List<Product> getAllGaming_chairs()
	{
		return prepo.getAllGaming_chairs();
	}
	
	public Product getById(int id)
	{
		return prepo.findById(id).get();
	}
	
	
	
	
	public boolean uploadProductImage(int id, byte[] photo)
	{
		if(prepo.uploadProductPicture(id, photo)==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
