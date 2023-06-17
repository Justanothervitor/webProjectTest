package com.prototype.webproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.webproject.entities.CategoryProperties;
import com.prototype.webproject.services.CategoryPropertiesService;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {
	
	@Autowired
	private CategoryPropertiesService categoryFinder;
	
    @GetMapping
	public ResponseEntity<List<CategoryProperties>> findAll() {
		List<CategoryProperties> list = categoryFinder.findAll();
		return ResponseEntity.ok().body(list);
	}
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryProperties> findById(@PathVariable Long id)
    {
    	CategoryProperties obj = categoryFinder.findById(id);
    	return ResponseEntity.ok().body(obj);
    }
    
}
