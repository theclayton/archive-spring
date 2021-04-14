package com.clayton.archive.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clayton.archive.models.Proj_tech;
import com.clayton.archive.models.Projects;

public interface Proj_techRepository extends JpaRepository<Proj_tech, Integer> {
	List<Proj_tech> findByprojectId(int projectId);
	List<Proj_tech> findByTechnologiesNameContaining(String name);
}
