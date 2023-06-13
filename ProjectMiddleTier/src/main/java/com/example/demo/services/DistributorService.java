package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Distributor;
import com.example.demo.entities.Expert;
import com.example.demo.entities.Login;
import com.example.demo.repositories.DistributorRepository;

@Service
public class DistributorService {

		@Autowired
		DistributorRepository drepo;
		
		public Distributor getDistributor(Login l)
		{
			return drepo.getDistributor(l);
		}
		
		public Distributor saveDistributor(Distributor d)
		{
			return drepo.save(d);
		}
		
		public List<Distributor> viewRegistrationReqOfDistri()
		{
			return drepo.viewRegistrationReqOfDistri();
		}
		
		public Distributor getById(int id)
		{
			return drepo.findById(id).get();
		}
		
		public boolean upload(int id, byte[] photo)
		{
			if(drepo.uploadPicture(id, photo)==1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
}
