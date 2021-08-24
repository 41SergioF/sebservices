package com.carlossergio.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlossergio.webservices.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	
}
