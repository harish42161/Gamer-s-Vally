package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Certification;
import com.example.demo.services.CertificationService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CertificationController {

		@Autowired
		CertificationService certservice;
		
		@GetMapping("/getAllCertification")
		public List<Certification> getAll()
		{
			return certservice.getAll();
		}
}
