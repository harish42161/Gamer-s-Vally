package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Login;
import com.example.demo.repositories.LoginRepository;

@Service
public class LoginService 
{
	@Autowired
	LoginRepository lrepo;
	
	public Login getLogin(String email,String pwd)
	{
		Login l;
		Optional<Login> ol=lrepo.getLogin(email, pwd);
		try
		{
			l=ol.get();
		}
		catch(Exception e) 
		{
			l = null;
		}
		return l;
		
	}
	
	public Login getById(int loginid)
	{
		return lrepo.findById(loginid).get();
	}
	
	public Login save(Login l)
	{
		return lrepo.save(l);
	}
	
	public int approveExpert(int loginid)
	{
		return lrepo.approveUser(loginid);
	}
	
	public int pendingExpert(int loginid)
	{
		return lrepo.pendingUser(loginid);
	}
	
	public int approveDistributor(int loginid)
	{
		return lrepo.approveUser(loginid);
	}
	
	public int pendingDistributor(int loginid)
	{
		return lrepo.pendingUser(loginid);
	}
	
	/*public List<Login> viewRegistrationReqOfExp()
	{
		return lrepo.viewRegistrationReqOfExp();
	}*/
}
