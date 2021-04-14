package com.clayton.archive.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clayton.archive.models.Links;

public interface LinksRepository extends JpaRepository<Links, Integer> {
	List<Links> findByprojectId(int projectId);
}
