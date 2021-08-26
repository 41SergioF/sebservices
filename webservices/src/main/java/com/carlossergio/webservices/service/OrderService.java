package com.carlossergio.webservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlossergio.webservices.entities.Order;
import com.carlossergio.webservices.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> optional =  orderRepository.findById(id);
		/*
		 * Esse linha retorna o objeto do tipo order contido
		 * no optional.
		 */
		return optional.get();
	}
}
