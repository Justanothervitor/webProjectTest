package com.prototype.webproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.prototype.webproject.entities.UserProperties;
import com.prototype.webproject.repositories.UserRepository;
import com.prototype.webproject.services.exceptions.DatabaseException;
import com.prototype.webproject.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public UserProperties insert(UserProperties obj)
	{
		return repository.save(obj);
	}
	
	public void delete(Long id)
	{
		try {
		
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e){
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public UserProperties update(Long id, UserProperties obj)
	{
		try {
		UserProperties entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		}

	private void updateData(UserProperties entity, UserProperties obj) 
	{
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		}

}
