package br.com.bakery.mocks;

import br.com.bakery.entities.Product;

public class MockProduct {
	
	public static Product mockProductVS5() {
		Product product = Product.builder()
			.code("VS5")
			.name("Vegemite Scroll")
			.packs(null)
			.build();
		
		product.setPacks(MockPack.mockPacksVS5(product));
		
		return product;
	}
	
	public static Product mockProductMB11() {
		Product product = Product.builder()
			.code("MB11")
			.name("Blueberry Muffin")
			.packs(null)
			.build();
		
		product.setPacks(MockPack.mockPacksMB11(product));
		
		return product;
	}
	
	public static Product mockProductCF() {
		Product product = Product.builder()
			.code("CF")
			.name("Croissant")
			.packs(null)
			.build();
		
		product.setPacks(MockPack.mockPacksCF(product));
		
		return product;
	}
}
