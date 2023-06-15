package com.prototype.webproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.webproject.entities.UserProperties;
import com.prototype.webproject.services.servicesForUsers;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private servicesForUsers dataFinder;
	
    @GetMapping
	public ResponseEntity<List<UserProperties>> findAll() {
		List<UserProperties> list = dataFinder.findAll();
		return ResponseEntity.ok().body(list);
	}
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserProperties> findById(@PathVariable Long id)
    {
    	UserProperties obj = dataFinder.findById(id);
    	return ResponseEntity.ok().body(obj);
    }
    
}
