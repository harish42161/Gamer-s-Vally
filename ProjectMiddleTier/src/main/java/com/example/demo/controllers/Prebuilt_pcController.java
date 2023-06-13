package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Expert;
import com.example.demo.entities.Prebuilt_pc;
import com.example.demo.services.ExpertService;
import com.example.demo.services.Prebuilt_pcService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Prebuilt_pcController 
{
	@Autowired
	Prebuilt_pcService preService;
	
	@Autowired
	ExpertService expService;
	
	@GetMapping("/getPrebuilt_pc")
	public List<Prebuilt_pc> getPrebuilt_pcByExperts(@RequestParam("expid") int exp_id)
	{
		Expert e=expService.getById(exp_id);
		return preService.getPrebuilt_pcByExperts(e);
	}
	
	@PostMapping("/AddPrebuilt_pc")
	public Prebuilt_pc AddPrebuilt_pc(@RequestBody Prebuilt_pc pbp ,@RequestParam("expid") int exp_id)
	{
		Expert e=expService.getById(exp_id); 
		Prebuilt_pc pp=new Prebuilt_pc(e,pbp.getMonitor(),pbp.getKeyboard(),pbp.getCabinet(),pbp.getMotherboard(),pbp.getSsd(),pbp.getMouse(),pbp.getGr_card(),pbp.getTotal_price());
		return preService.AddPrebuilt_pc(pp);
	}
}
