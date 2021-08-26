package com.carlossergio.webservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlossergio.webservices.entities.Category;
import com.carlossergio.webservices.repositories.CategoryRepository;

@Service
public class CategoryServer {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> optional = categoryRepository.findById(id);
		return optional.get();
	}
}
