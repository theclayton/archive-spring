package com.clayton.archive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clayton.archive.models.Links;
import com.clayton.archive.repositories.LinksRepository;


@RestController
public class LinksController {
	@Autowired
	LinksRepository repo;
	
	@CrossOrigin
	@GetMapping("/api/links/project/{projectId}")
	public List<Links> getProject(@PathVariable("projectId") int projectId) {
		return repo.findByprojectId(projectId);
	}
	
	@CrossOrigin
	@PostMapping("/api/links/project/create")
	 public ResponseEntity<String> createLink(@RequestBody Links links) {  
		try {
			repo.save(links);
		    return new ResponseEntity<String>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin
	@DeleteMapping("api/links/project/delete/{id}")
	public ResponseEntity<String> deleteLink(@PathVariable("id") int id) {
		try {
			repo.deleteById(id);
		    return new ResponseEntity<String>(HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
