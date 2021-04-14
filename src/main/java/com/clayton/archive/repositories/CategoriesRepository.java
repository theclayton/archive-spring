package com.clayton.archive.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clayton.archive.models.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer>  {
}
