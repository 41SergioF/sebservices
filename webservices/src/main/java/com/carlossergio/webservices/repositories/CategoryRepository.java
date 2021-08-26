package com.carlossergio.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlossergio.webservices.entities.Category;
/*
 * Essa classe não precisa de anotação pois da qual ela extende
 * já foi feita a anotação */
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
