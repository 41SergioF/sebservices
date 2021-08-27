package com.carlossergio.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlossergio.webservices.entities.OrderItem;

/*
 * Essa classe não precisa de anotação pois da qual ela extende
 * já foi feita a anotação */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
