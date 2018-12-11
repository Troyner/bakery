package br.com.bakery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bakery.entities.Product;
import br.com.bakery.exceptions.FindException;
import br.com.bakery.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	/**
	 * Find a product by his code.
	 * @param code
	 * @return Product
	 * @throws FindException
	 */
	@Override
	public Product findByCode(String code) throws FindException {
		return repository.findByCode(code).orElseThrow(() -> new FindException("Product not found"));
	}

}
