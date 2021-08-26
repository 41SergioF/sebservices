package com.carlossergio.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlossergio.webservices.entities.Product;
/*
 * Essa classe não precisa de anotação pois da qual ela extende
 * já foi feita a anotação */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
