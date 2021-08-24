package com.carlossergio.webservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlossergio.webservices.entities.User;
import com.carlossergio.webservices.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> optional =  userRepository.findById(id);
		/*
		 * Esse linha retorna o objeto do tipo User contido
		 * no optional.
		 */
		return optional.get();
	}
}
