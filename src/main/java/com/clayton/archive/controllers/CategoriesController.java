package com.clayton.archive.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.clayton.archive.models.Categories;
import com.clayton.archive.models.Projects;
import com.clayton.archive.models.Triple;
import com.clayton.archive.repositories.CategoriesRepository;
import com.clayton.archive.repositories.ProjectsRepository;

@RestController
public class CategoriesController {
	@Autowired
	CategoriesRepository repo;
	
	@Autowired
	ProjectsRepository projectsRepo;
	
	@CrossOrigin
	@GetMapping("/api/categories")
	public List<Categories> getCatergories() {
		return repo.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/api/categories/count-each")
	public List<Triple> getCatergoriesCountEach() {
		List<Categories> categories = repo.findAll();
		List<Triple> result = new ArrayList<>();
		
		int otherCount = 0;
		int pos = 1;
		for (Categories category: categories) {
			String categoryName = category.getName();
			
			List<Projects> projects = projectsRepo.findByCategoriesNameContaining(categoryName);
			int projectsCount = projects.size();
			
			if (projectsCount <= 2) {
				otherCount += projectsCount;
				continue;
			} else {
				Triple newTriple = new Triple(pos, categoryName, projectsCount);
				result.add(newTriple);				
				pos++;
			}
		}
		
		Triple newTriple = new Triple(pos, "other", otherCount);
		result.add(newTriple);
		
		return result;
	}
	
	@CrossOrigin
	@PostMapping("/api/categories/create")
	 public ResponseEntity<String> createCategory(@RequestBody Categories categories) {  
		try {
			repo.save(categories);
		    return new ResponseEntity<String>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
