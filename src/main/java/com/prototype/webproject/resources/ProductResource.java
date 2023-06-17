package com.prototype.webproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.webproject.entities.ProductProperties;
import com.prototype.webproject.services.ProductPropertiesService;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {
	
	@Autowired
	private ProductPropertiesService productFinder;
	
    @GetMapping
	public ResponseEntity<List<ProductProperties>> findAll() {
		List<ProductProperties> list = productFinder.findAll();
		return ResponseEntity.ok().body(list);
	}
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductProperties> findById(@PathVariable Long id)
    {
    	ProductProperties obj = productFinder.findById(id);
    	return ResponseEntity.ok().body(obj);
    }
    
}
