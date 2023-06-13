package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Login;
import com.example.demo.repositories.CustomerRepository;

@Service
public class CustomerService 
{
	@Autowired
	CustomerRepository crepo;
	
	public Customer getCustomer(Login l)
	{
		return crepo.getCustomer(l);
	}
	public Customer saveCustomer(Customer c)
	{
		return crepo.save(c);
	}
	
	public Customer getById(int c)
	{
		return crepo.findById(c).get();
	}

}
