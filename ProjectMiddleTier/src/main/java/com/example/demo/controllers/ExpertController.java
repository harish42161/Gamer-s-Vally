package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Distributor;
import com.example.demo.entities.Expert;
import com.example.demo.entities.ExpertReg;
import com.example.demo.entities.Login;
import com.example.demo.entities.PassBasedEnc;
import com.example.demo.entities.Prebuilt_pc;
import com.example.demo.entities.Question;
import com.example.demo.entities.Requirement;
import com.example.demo.entities.Response;
import com.example.demo.entities.Role;
import com.example.demo.entities.SaltValue;
import com.example.demo.services.ExpertService;
import com.example.demo.services.LoginService;
import com.example.demo.services.Prebuilt_pcService;
import com.example.demo.services.QuestionService;
import com.example.demo.services.RequirementService;
import com.example.demo.services.ResponseService;
import com.example.demo.services.RoleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ExpertController {
	
	@Autowired
	ExpertService expservice;
	
	@Autowired
	LoginService lservice;
	
	@Autowired
	RoleService rservice;
	
	@Autowired
	QuestionService qservice;
	
	@Autowired
	Prebuilt_pcService preservice;
	
	@Autowired
	RequirementService reqservice;
	
	@Autowired
	ResponseService resservice;
	
	@Autowired
	SaltValue saltValue;
	
	@GetMapping("/getExpert")
	public Expert getExpert(@RequestParam("loginid") int loginid)
	{
		Login l = lservice.getById(loginid);
		return expservice.getExpert(l); 
	}
	
	@GetMapping("/viewPrebuilt_pc")
	public List<Prebuilt_pc> viewPrebuilt_pc(@RequestParam("exp_id") int exp_id)
	{
		Expert e=expservice.getById(exp_id);
		return preservice.getPrebuilt_pcByExperts(e); 
	}
	
	@GetMapping("/suggestPrebuiltpc")
	public Response suggestPrebuiltpc(@RequestParam("pc_id") int pc_id,@RequestParam("req_id") int req_id)
	{
		Prebuilt_pc pc=preservice.getById(pc_id);
		Requirement req=reqservice.getById(req_id);
		Response res=new Response(req,pc);
		return resservice.suggestPrebuiltpc(res); 
	}
	
	@PostMapping("/regExpert")
	public Expert regExpert(@RequestBody ExpertReg er)
	{
		Role r= rservice.getRole(4);
		System.out.println(saltValue.getSalt());
		String encrypted=PassBasedEnc.generateSecurePassword(er.getPwd(), saltValue.getSalt());
		
		Question q= qservice.getQuestion(er.getQuestion());
		Login l = new Login(er.getEmail(),encrypted,r,q,er.getAnswer(),false);
		Login saved= lservice.save(l);
		
		Expert e=new Expert(er.getFname(),er.getLname(),er.getMobile(),saved,er.getCertification(),er.getExperience());
		return expservice.saveExpert(e);
	}
	
	@PostMapping(value="/uploadImage/{exp_id}",consumes="multipart/form-data")
	public boolean uploadPicture(@PathVariable("exp_id")int eid,@RequestBody MultipartFile file)
	{
		boolean flag=true;
		try
		{
			expservice.upload(eid, file.getBytes());
		}
		catch(Exception e)
		{
			flag=false;
		}
		return flag;
		
	}
	
	@GetMapping("/deletePrebuilt_pc")
	public int deletePrebuilt_pc(@RequestParam("pc_id") int pc_id)
	{
		return preservice.deletePrebuilt_pc(pc_id); 
	}
	
	
	
	
	
	
	

}
