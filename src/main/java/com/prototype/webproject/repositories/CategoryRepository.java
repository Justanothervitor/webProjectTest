package com.prototype.webproject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.webproject.entities.CategoryProperties;

public interface CategoryRepository extends JpaRepository<CategoryProperties, Long> {

	
	
}
