package com.prototype.webproject.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    
    @PostMapping
    public ResponseEntity<UserProperties> insert (@RequestBody UserProperties obj)
    {
    	obj = dataFinder.insert(obj);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    	
    	return  ResponseEntity.created(uri).body(obj);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
    	dataFinder.delete(id);
    	return ResponseEntity.noContent().build();
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserProperties> update(@PathVariable Long id,@RequestBody UserProperties obj)
    {
    	obj = dataFinder.update(id, obj);
    	return ResponseEntity.ok().body(obj);
    }
    
}
