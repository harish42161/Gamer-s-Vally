package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.AddProduct;
import com.example.demo.entities.Brand;
import com.example.demo.entities.Category;
import com.example.demo.entities.Distributor;
import com.example.demo.entities.Expert;
import com.example.demo.entities.ExpertReg;
import com.example.demo.entities.Login;
import com.example.demo.entities.Product;
import com.example.demo.entities.Question;
import com.example.demo.entities.Role;
import com.example.demo.entities.SaltValue;
import com.example.demo.services.BrandService;
import com.example.demo.services.CategoryService;
import com.example.demo.services.DistributorService;
import com.example.demo.services.ExpertService;
import com.example.demo.services.LoginService;
import com.example.demo.services.ProductService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AdminController 
{
	@Autowired
	CategoryService catservice;
	
	@Autowired
	BrandService brservice;
	
	@Autowired
	ProductService prodservice;
	
	@Autowired
	LoginService lservice;
	
	@Autowired
	ExpertService expservice;
	
	@Autowired
	DistributorService distservice;
	
	@Autowired
	SaltValue saltValue;
	
	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory()
	{
		return catservice.getAllCategory();
	}
	
	@GetMapping("/getAllBrands")
	public List<Brand> getAllBrands()
	{
		return brservice.getAllBrands();
	}
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody AddProduct ap)
	{
		Category cat= catservice.getById(ap.getCategory());
		Brand br= brservice.getById(ap.getBrand());
		Product prod = new Product(cat,br,ap.getDescription(),ap.getPrice());
		return prodservice.saveProduct(prod);
	}
	
	@GetMapping("/viewRegistrationReqOfExp")
	public List<Expert> viewRegistrationReqOfExp()
	{
		return expservice.viewRegistrationReqOfExp();
	}
	
	@GetMapping("/viewRegistrationReqOfDistri")
	public List<Distributor> viewRegistrationReqOfDistri()
	{
		return distservice.viewRegistrationReqOfDistri();
	}
	
	@GetMapping("/approveExpert")
	public int approveExpert(@RequestParam("exp_id") int exp_id)
	{
		Expert exp=expservice.getById(exp_id);
		Login l=exp.getLogin_id();
		int loginid=l.getLogin_id();
		return lservice.approveExpert(loginid); 
	}
	
	@GetMapping("/pendingExpert")
	public int pendingExpert(@RequestParam("exp_id") int exp_id)
	{
		Expert exp=expservice.getById(exp_id);
		Login l=exp.getLogin_id();
		int loginid=l.getLogin_id();
		return lservice.pendingExpert(loginid); 
	}
	
	@GetMapping("/approveDistributor")
	public int approveDistributor(@RequestParam("distri_id") int distri_id)
	{
		Distributor dist=distservice.getById(distri_id);
		Login l=dist.getLogin_id();
		int loginid=l.getLogin_id();
		return lservice.approveDistributor(loginid); 
	}
	
	@GetMapping("/pendingDistributor")
	public int pendingDistributor(@RequestParam("distri_id") int distri_id)
	{
		Distributor dist=distservice.getById(distri_id);
		Login l=dist.getLogin_id();
		int loginid=l.getLogin_id();
		return lservice.pendingDistributor(loginid); 
	}
	
	
	@PostMapping(value="/uploadProductImage/{prod_id}",consumes="multipart/form-data")
	public boolean uploadProductImage(@PathVariable("prod_id")int pid,@RequestBody MultipartFile file)
	{
		boolean flag=true;
		try
		{
			prodservice.uploadProductImage(pid, file.getBytes());
		}
		catch(Exception e)
		{
			flag=false;
		}
		return flag;
		
	}
}
