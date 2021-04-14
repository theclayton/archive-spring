package com.clayton.archive.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clayton.archive.models.Images;

public interface ImagesRepository extends JpaRepository<Images, Integer> {
	List<Images> findByprojectId(int projectId);

}
