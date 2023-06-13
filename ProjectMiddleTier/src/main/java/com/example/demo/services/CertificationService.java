package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Certification;
import com.example.demo.repositories.CertificationRepository;

@Service
public class CertificationService {

	@Autowired
	CertificationRepository certrepo;
	
	public List<Certification> getAll()
	{
		return certrepo.findAll();
	}
}
