package br.com.bakery.businesses;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.bakery.entities.Product;
import br.com.bakery.exceptions.FindException;
import br.com.bakery.mocks.MockProduct;
import br.com.bakery.services.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductBusinessTest {

	@Mock
	private ProductService productService;
	
	@InjectMocks
	private ProductBusiness orderBusiness;
	
	private Product mockedProductVS5 = MockProduct.mockProductVS5();
	
	@Test
	public void testFindPacksByProductCode() throws FindException {
		when(productService.findByCode(mockedProductVS5.getCode())).thenReturn(mockedProductVS5);
		assertEquals(mockedProductVS5.getPacks(), orderBusiness.findPacksByProductCode(mockedProductVS5.getCode()));
	}

	@Test(expected = FindException.class)
	public void testFindPacksByProductCodeException() throws FindException {
		String errorCode = "ERROR_CODE";
		
		when(productService.findByCode(errorCode)).thenThrow(new FindException("Product not found"));
		orderBusiness.findPacksByProductCode(errorCode);
	}
	
}
