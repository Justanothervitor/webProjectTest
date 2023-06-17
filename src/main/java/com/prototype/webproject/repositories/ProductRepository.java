package com.prototype.webproject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.webproject.entities.ProductProperties;

public interface ProductRepository extends JpaRepository<ProductProperties, Long> {

	
	
}
