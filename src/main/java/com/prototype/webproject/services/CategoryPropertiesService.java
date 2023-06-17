package com.prototype.webproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.webproject.entities.CategoryProperties;
import com.prototype.webproject.repositories.CategoryRepository;

@Service
public class CategoryPropertiesService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<CategoryProperties> findAll()
	{
		return repository.findAll();
	}
	
	public CategoryProperties findById(Long id)
	{
		Optional<CategoryProperties> obj = repository.findById(id);
		return obj.get();
	}

}
