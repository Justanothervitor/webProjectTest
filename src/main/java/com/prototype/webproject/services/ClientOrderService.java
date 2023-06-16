package com.prototype.webproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.webproject.entities.ClientOrder;
import com.prototype.webproject.repositories.ClientOrderRepository;

@Service
public class ClientOrderService {
	
	@Autowired
	private ClientOrderRepository repository;
	
	public List<ClientOrder> findAll()
	{
		return repository.findAll();
	}
	
	public ClientOrder findById(Long id)
	{
		Optional<ClientOrder> obj = repository.findById(id);
		return obj.get();
	}

}
