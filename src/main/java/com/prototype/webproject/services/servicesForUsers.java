package com.prototype.webproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.webproject.entities.UserProperties;
import com.prototype.webproject.repositories.UserRepository;

@Service
public class servicesForUsers {
	
	@Autowired
	private UserRepository repository;
	
	public List<UserProperties> findAll()
	{
		return repository.findAll();
	}
	
	public UserProperties findById(Long id)
	{
		Optional<UserProperties> obj = repository.findById(id);
		return obj.get();
	}
	
	public UserProperties insert(UserProperties obj)
	{
		return repository.save(obj);
	}

}
