package com.prototype.webproject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.webproject.entities.ClientOrder;

public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {

	
	
}
