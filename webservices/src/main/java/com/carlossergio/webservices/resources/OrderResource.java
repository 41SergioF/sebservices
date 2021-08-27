package com.carlossergio.webservices.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlossergio.webservices.entities.Order;
import com.carlossergio.webservices.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	/*
	 * Injeção de dependência
	 */
	@Autowired
	private OrderService orderService;

	/*
	 * Funcionamento do método: A classe OrderResource pede a OrderService todas a
	 * entidades contidas no BD
	 */
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = orderService.findAll();

		return ResponseEntity.ok().body(list);
	}

	/*
	 * Esse trexo "(value = "/{id}")", diz que o resource
	 * receberá uma valor de Id
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order order = orderService.findById(id);
		return ResponseEntity.ok().body(order);
	}
}
