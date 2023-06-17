package com.prototype.webproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.webproject.entities.ProductProperties;
import com.prototype.webproject.repositories.ProductRepository;

@Service
public class ProductPropertiesService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<ProductProperties> findAll()
	{
		return repository.findAll();
	}
	
	public ProductProperties findById(Long id)
	{
		Optional<ProductProperties> obj = repository.findById(id);
		return obj.get();
	}

}
