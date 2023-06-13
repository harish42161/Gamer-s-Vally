package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Requirement;
import com.example.demo.entities.Response;
import com.example.demo.repositories.ResponseRepository;

@Service
public class ResponseService 
{
	@Autowired
	ResponseRepository resrepo;
	
	
	public Response suggestPrebuiltpc(Response e)
	{
		return resrepo.save(e);
	}
}
