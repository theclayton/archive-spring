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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.clayton.archive.models.Proj_tech;
import com.clayton.archive.models.Projects;
import com.clayton.archive.models.Technologies;
import com.clayton.archive.models.Triple;
import com.clayton.archive.repositories.Proj_techRepository;

@RestController
public class Proj_techController {
	@Autowired
	Proj_techRepository repo;
	
	@CrossOrigin
	@GetMapping("/api/technologies/project/{projectId}")
	public List<Proj_tech> getTechnologies(@PathVariable("projectId") int projectId) {
		return repo.findByprojectId(projectId);
	}
	
	@CrossOrigin
	@GetMapping("/api/technologies/graph")
	public List<Triple> getTechnologies() {
		List<Triple> result = new ArrayList<>();
		List<String> technolgies = new ArrayList<>();
		technolgies.add("JavaScript");
		technolgies.add("Node");
		technolgies.add("Swift");
		technolgies.add("AWS Lambda");
		technolgies.add("MySQL");
		technolgies.add("MongoDB");
		technolgies.add("Gimp");
		
		int pos = 1;
		for (String technology: technolgies) {
			List<Proj_tech> projTechs = repo.findByTechnologiesNameContaining(technology);
			int projectsCount = projTechs.size();
			
			Triple newTriple = new Triple(pos, technology, projectsCount);
			result.add(newTriple);				
			pos++;
		}
		return result;
	}
	
	@CrossOrigin
	@PostMapping("/api/technologies/project/create")
	 public ResponseEntity<String> createProjTech(@RequestBody Proj_tech proj_tech) {  
		try {
			repo.save(proj_tech);
		    return new ResponseEntity<String>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin
	@DeleteMapping("api/technologies/project/delete/{id}")
	public ResponseEntity<String> deleteProjTech(@PathVariable("id") int id) {
		try {
			repo.deleteById(id);
		    return new ResponseEntity<String>(HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
