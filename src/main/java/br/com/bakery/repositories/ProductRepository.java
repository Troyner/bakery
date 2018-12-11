package br.com.bakery.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bakery.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	/**
	 * Find a Product by code.
	 * @param cardNumber
	 * @return Optional<Product>
	 */
	Optional<Product> findByCode(String code);
	
}