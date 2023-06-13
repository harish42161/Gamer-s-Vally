package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Certification;
import com.example.demo.entities.Expert;
import com.example.demo.entities.Requirement;
import com.example.demo.repositories.RequirementRepository;

@Service
public class RequirementService 
{
	@Autowired
	RequirementRepository reqRepo;
	
	public List<Requirement> getRequirementByExperts(Expert e)
	{
		return reqRepo.getRequirementByExperts(e);
	}
	
	public Requirement sendRequirement(Requirement e)
	{
		return reqRepo.save(e);
	}
	
	public Requirement getById(int e)
	{
		return reqRepo.findById(e).get();
	}
	
}
