package com.prototype.webproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.webproject.entities.ClientOrder;
import com.prototype.webproject.services.ClientOrderService;

@RestController
@RequestMapping(value = "/orders")
public class ClientOrderResource {
	
	@Autowired
	private ClientOrderService dataFinder;
	
    @GetMapping
	public ResponseEntity<List<ClientOrder>> findAll() {
		List<ClientOrder> list = dataFinder.findAll();
		return ResponseEntity.ok().body(list);
	}
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientOrder> findById(@PathVariable Long id)
    {
    	ClientOrder obj = dataFinder.findById(id);
    	return ResponseEntity.ok().body(obj);
    }
    
}
