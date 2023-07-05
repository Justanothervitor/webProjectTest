package com.prototype.webproject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.webproject.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	
	
}
