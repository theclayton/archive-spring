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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clayton.archive.models.Images;
import com.clayton.archive.models.Links;
import com.clayton.archive.models.Projects;
import com.clayton.archive.repositories.ImagesRepository;

@RestController
public class ImagesController {
	@Autowired
	ImagesRepository repo;
	
	@CrossOrigin
	@GetMapping("/api/images/project/{projectId}")
	public List<Images> getProject(@PathVariable("projectId") int projectId) {
		return repo.findByprojectId(projectId);
	}
	
	@CrossOrigin
	@PostMapping("/api/images/project/create")
	 public ResponseEntity<String> createImage(@RequestBody Images images) {  
		try {
			repo.save(images);
		    return new ResponseEntity<String>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin
	@PutMapping("api/images/project")
	 public ResponseEntity<String> updateImage(@RequestBody Images images) {
		try {
			repo.save(images);
		    return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin
	@DeleteMapping("api/images/project/delete/{id}")
	public ResponseEntity<String> deleteImage(@PathVariable("id") int id) {
		try {
			repo.deleteById(id);
		    return new ResponseEntity<String>(HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
