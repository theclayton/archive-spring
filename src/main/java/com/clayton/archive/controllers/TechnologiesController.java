package com.clayton.archive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clayton.archive.models.Technologies;
import com.clayton.archive.repositories.TechnologiesRepository;

@RestController
public class TechnologiesController {
	@Autowired
	TechnologiesRepository repo;
	
	@CrossOrigin
	@GetMapping("/api/technologies")
	public List<Technologies> getTechnologies() {
		return repo.findAll();
	}
	
	@CrossOrigin
	@PostMapping("/api/technologies/create")
	 public ResponseEntity<String> createTechnology(@RequestBody Technologies technologies) {  
		try {
			repo.save(technologies);
		    return new ResponseEntity<String>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
