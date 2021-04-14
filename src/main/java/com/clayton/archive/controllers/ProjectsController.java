package com.clayton.archive.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clayton.archive.models.Categories;
import com.clayton.archive.models.Projects;
import com.clayton.archive.models.Triple;
import com.clayton.archive.repositories.ProjectsRepository;


@RestController
public class ProjectsController {
	@Autowired
	ProjectsRepository repo;
	
	@CrossOrigin
	@GetMapping("/api/projects")
	public List<Projects> getProjects() {
		return repo.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/api/projects/{id}")
	public Projects getProject(@PathVariable("id") int id) {
		return repo.findById(id).orElseThrow();
	}
	
	@CrossOrigin
	@GetMapping("/api/projects/count")
	public long getProjectCount() {
		return repo.count();
	}
		
	@CrossOrigin
	@GetMapping("/api/projects/featured")
	public List<Projects> getFeaturedProjects() {
		return repo.findByFeaturedTrue();
	}
	
	@CrossOrigin
	@GetMapping("/api/search")
	public List<Projects> getSearchResults(@RequestParam(required=true) String terms) {
		return repo.findByTitleContainingOrSubtitleContainingOrDescriptionContainingOrCategoriesNameContaining(terms, terms, terms, terms);
	}

	@CrossOrigin
	@PostMapping("/api/projects/create")
	 public ResponseEntity<String> createProject(@RequestBody Projects projects) {  
		try {
			repo.save(projects);
		    return new ResponseEntity<String>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@CrossOrigin
	@PutMapping("api/projects/update")
	 public ResponseEntity<String> updateProject(@RequestBody Projects projects) {
		try {
			repo.save(projects);
		    return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin
	@DeleteMapping("api/projects/delete/{id}")
	public ResponseEntity<String> deleteProject(@PathVariable("id") int id) {
		try {
			repo.deleteById(id);
		    return new ResponseEntity<String>(HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
