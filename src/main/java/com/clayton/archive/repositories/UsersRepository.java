package com.clayton.archive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clayton.archive.models.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	Users findByUsername(String username);
}
