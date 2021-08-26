package com.carlossergio.webservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlossergio.webservices.entities.Product;
import com.carlossergio.webservices.repositories.ProductRepository;

@Service
public class ProductServer {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> optional = productRepository.findById(id);
		return optional.get();
	}
}
