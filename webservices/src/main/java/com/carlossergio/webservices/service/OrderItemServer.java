package com.carlossergio.webservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlossergio.webservices.entities.OrderItem;
import com.carlossergio.webservices.repositories.OrderItemRepository;

@Service
public class OrderItemServer {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public List<OrderItem> findAll(){
		return orderItemRepository.findAll();
	}

	public OrderItem findById(Long id) {
		Optional<OrderItem> optional = orderItemRepository.findById(id);
		return optional.get();
	}
}
