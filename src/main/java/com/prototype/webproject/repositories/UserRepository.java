package com.prototype.webproject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.webproject.entities.UserProperties;

public interface UserRepository extends JpaRepository<UserProperties, Long> {

	
	
}
