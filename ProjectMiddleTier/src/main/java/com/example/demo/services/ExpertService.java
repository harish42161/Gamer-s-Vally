package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Expert;
import com.example.demo.entities.Login;
import com.example.demo.repositories.ExpertRepository;

@Service
public class ExpertService 
{
	@Autowired
	ExpertRepository exprepo;
	
	public Expert getExpert(Login l)
	{
		return exprepo.getExpert(l);
	}

	public Expert saveExpert(Expert e)
	{
		return exprepo.save(e);
	}
	
	public Expert getById(int expid)
	{
		return exprepo.findById(expid).get();
	}
	
	public byte[] getExpImage(int expid)
	{
		return exprepo.getExpImage(expid);
	}
	
	public List<Expert> viewRegistrationReqOfExp()
	{
		return exprepo.viewRegistrationReqOfExp();
	}
	
	public List<Expert> viewAllExperts()
	{
		return exprepo.findAll();
	}
	
	public boolean upload(int id, byte[] photo)
	{
		if(exprepo.uploadPicture(id, photo)==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
