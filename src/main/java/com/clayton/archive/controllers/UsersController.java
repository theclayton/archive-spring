package com.clayton.archive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clayton.archive.models.Users;
import com.clayton.archive.repositories.UsersRepository;

@RestController
public class UsersController {
	@Autowired
	UsersRepository repo;
	
	@CrossOrigin
	@GetMapping("/api/users")
	public List<Users> getUsers() {
		return repo.findAll();
	}
}
