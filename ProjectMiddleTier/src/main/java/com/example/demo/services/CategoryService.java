package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;

@Service
public class CategoryService 
{
	@Autowired
	CategoryRepository catrepo;
	
	public List<Category> getAllCategory()
	{
		return catrepo.findAll();
	}
	
	public Category getById(int id)
	{
		return catrepo.findById(id).get();
	}
}
