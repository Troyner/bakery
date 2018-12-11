package br.com.bakery.mocks;

import br.com.bakery.dtos.PackDTO;

public class MockPackDTO {
	
	public static PackDTO mockTwoPacksOfFiveVS5() {
		return PackDTO.builder()
			.packQuantity(2)
			.productQuantity(5)
			.packCost(8.99)
			.build();
	}
	
	public static PackDTO mockOnePackOfEightMB11() {
		return PackDTO.builder()
			.packQuantity(1)
			.productQuantity(8)
			.packCost(24.95)
			.build();
	}
	
	public static PackDTO mockThreePacksOfTwoMB11() {
		return PackDTO.builder()
			.packQuantity(3)
			.productQuantity(2)
			.packCost(9.95)
			.build();
	}
	
	public static PackDTO mockTwoPacksOfFiveCF() {
		return PackDTO.builder()
			.packQuantity(2)
			.productQuantity(5)
			.packCost(9.95)
			.build();
	}
	
	public static PackDTO mockOnePackOfThreeCF() {
		return PackDTO.builder()
			.packQuantity(1)
			.productQuantity(3)
			.packCost(5.95)
			.build();
	}
	
}
