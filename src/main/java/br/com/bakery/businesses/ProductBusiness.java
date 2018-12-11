
package br.com.bakery.businesses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bakery.entities.Pack;
import br.com.bakery.entities.Product;
import br.com.bakery.exceptions.FindException;
import br.com.bakery.services.ProductService;

/**
 * Class responsible for being the business 
 * implementation of processes related to Product.
 * @author marcus.martins
 */
@Component
public class ProductBusiness {
	
	@Autowired
	private ProductService productService;
	
	/**
	 * Find product packs from the passed code.
	 * @param code
	 * @return List<Pack>
	 * @throws FindException
	 */
	public List<Pack> findPacksByProductCode(String code) throws FindException {
		try {
			Product product = this.productService.findByCode(code);
			return product.getPacks();
		} catch (FindException e) {
			throw e;
		} catch (Exception e) {
			throw new FindException("Unknown error at finding packs", e);
		}
	}
}
