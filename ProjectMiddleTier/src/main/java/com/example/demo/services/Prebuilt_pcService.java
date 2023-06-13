package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Expert;
import com.example.demo.entities.Prebuilt_pc;
import com.example.demo.repositories.Prebuilt_pcRepository;

@Service
public class Prebuilt_pcService 
{
	@Autowired
	Prebuilt_pcRepository preRepo;
	
	public List<Prebuilt_pc> getPrebuilt_pcByExperts(Expert e)
	{
		return preRepo.getPrebuilt_pcByExperts(e);
	}
	
	public Prebuilt_pc AddPrebuilt_pc(Prebuilt_pc p)
	{
		return preRepo.save(p);
	}
	
	public Prebuilt_pc getById(int id)
	{
		return preRepo.findById(id).get();
	}
	
	public int deletePrebuilt_pc(int pc_id)
	{
		return preRepo.deletePrebuilt_pc(pc_id);
	}
}
