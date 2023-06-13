package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Question;
import com.example.demo.services.QuestionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class QuestionController {

		@Autowired
		QuestionService questservice;
		
		@GetMapping("/getAllQuestion")
		public List<Question> getAll()
		{
			return questservice.getAll();
		}
}
