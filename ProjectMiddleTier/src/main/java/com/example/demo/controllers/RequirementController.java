package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Expert;
import com.example.demo.entities.Requirement;
import com.example.demo.services.ExpertService;
import com.example.demo.services.RequirementService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RequirementController 
{
	@Autowired
	RequirementService reqService;
	
	@Autowired
	ExpertService expService;
	
	@GetMapping("/getRequirements")
	public List<Requirement> getRequirementByExperts(@RequestParam("expid") int exp_id)
	{
		Expert e=expService.getById(exp_id);
		return reqService.getRequirementByExperts(e);
	}
}
