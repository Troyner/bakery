package br.com.bakery.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.bakery.entities.Pack;
import br.com.bakery.entities.Product;

public class MockPack {
	
	public static List<Pack> mockPacksVS5(Product product) {
		List<Pack> packs = new ArrayList<>();
		packs.add(Pack.builder()
				.id(1)
				.productQuantity(3)
				.packCost(6.99)
				.product(product)
				.build());
		packs.add(Pack.builder()
				.id(2)
				.productQuantity(5)
				.packCost(8.99)
				.product(product)
				.build());
		
		return packs;
	}
	
	public static List<Pack> mockPacksMB11(Product product) {
		List<Pack> packs = new ArrayList<>();
		packs.add(Pack.builder()
				.id(3)
				.productQuantity(2)
				.packCost(9.95)
				.product(product)
				.build());
		packs.add(Pack.builder()
				.id(4)
				.productQuantity(5)
				.packCost(16.95)
				.product(product)
				.build());
		packs.add(Pack.builder()
				.id(5)
				.productQuantity(8)
				.packCost(24.95)
				.product(product)
				.build());
		
		return packs;
	}
	
	public static List<Pack> mockPacksCF(Product product) {
		List<Pack> packs = new ArrayList<>();
		packs.add(Pack.builder()
				.id(6)
				.productQuantity(3)
				.packCost(5.95)
				.product(product)
				.build());
		packs.add(Pack.builder()
				.id(7)
				.productQuantity(5)
				.packCost(9.95)
				.product(product)
				.build());
		packs.add(Pack.builder()
				.id(8)
				.productQuantity(9)
				.packCost(16.99)
				.product(product)
				.build());
		
		return packs;
	}
}
