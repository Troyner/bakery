package br.com.bakery.services;

import br.com.bakery.entities.Product;
import br.com.bakery.exceptions.FindException;

public interface ProductService {

	/**
	 * Find a product by his code.
	 * @param code
	 * @return Product
	 * @throws FindException
	 */
	Product findByCode(String code) throws FindException;
	
}
