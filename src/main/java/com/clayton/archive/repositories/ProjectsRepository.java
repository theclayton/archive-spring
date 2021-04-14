package com.clayton.archive.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clayton.archive.models.Projects;

public interface ProjectsRepository extends JpaRepository<Projects, Integer> {
	
	List<Projects> findByFeaturedTrue();
	List<Projects> findByCategoriesNameContaining(String name);
	List<Projects> findByTitleContainingOrSubtitleContainingOrDescriptionContainingOrCategoriesNameContaining(String terms, String terms2, String terms3, String terms4);
}
