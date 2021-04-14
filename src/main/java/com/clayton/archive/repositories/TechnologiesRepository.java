package com.clayton.archive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clayton.archive.models.Technologies;

public interface TechnologiesRepository extends JpaRepository<Technologies, Integer> {

}
