package br.com.bakery.businesses;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.bakery.dtos.PackDTO;
import br.com.bakery.exceptions.EmptyParametersException;
import br.com.bakery.exceptions.InvalidQuantityException;
import br.com.bakery.exceptions.NoPackCombinationException;
import br.com.bakery.mocks.MockPackDTO;
import br.com.bakery.mocks.MockProduct;

@RunWith(MockitoJUnitRunner.class)
public class PackBusinessTest {

	@InjectMocks
	private PackBusiness packBusiness;
	
	@Test
	public void testGetMinPackCombinationVS5() throws NoPackCombinationException, EmptyParametersException, InvalidQuantityException {
		List<PackDTO> packs = new ArrayList<>();
		packs.add(MockPackDTO.mockTwoPacksOfFiveVS5());
		assertEquals(packs, packBusiness.getMinPackCombination(MockProduct.mockProductVS5().getPacks(), 10));
	}

	@Test(expected = NoPackCombinationException.class)
	public void testGetMinPackCombinationVS5NoPackCombinationException() throws NoPackCombinationException, EmptyParametersException, InvalidQuantityException  {
		packBusiness.getMinPackCombination(MockProduct.mockProductVS5().getPacks(), 11);
	}
	
	@Test(expected = EmptyParametersException.class)
	public void testGetMinPackCombinationVS5EmptyParametersException() throws NoPackCombinationException, EmptyParametersException, InvalidQuantityException {
		fail("Product with no packs", packBusiness.getMinPackCombination(new ArrayList<>(), 10));
	}
	
	@Test(expected = InvalidQuantityException.class)
	public void testGetMinPackCombinationVS5InvalidQuantityException() throws NoPackCombinationException, EmptyParametersException, InvalidQuantityException {
		fail("Invalid quantity of products", packBusiness.getMinPackCombination(MockProduct.mockProductVS5().getPacks(), -1));
	}
	
	@Test
	public void testGetMinPackCombinationMB11() throws NoPackCombinationException, EmptyParametersException, InvalidQuantityException {
		List<PackDTO> packs = new ArrayList<>();
		packs.add(MockPackDTO.mockOnePackOfEightMB11());
		packs.add(MockPackDTO.mockThreePacksOfTwoMB11());
		
		assertEquals(packs, packBusiness.getMinPackCombination(MockProduct.mockProductMB11().getPacks(), 14));
	}
	
	@Test
	public void testGetMinPackCombinationCF() throws NoPackCombinationException, EmptyParametersException, InvalidQuantityException {
		List<PackDTO> packs = new ArrayList<>();
		packs.add(MockPackDTO.mockTwoPacksOfFiveCF());
		packs.add(MockPackDTO.mockOnePackOfThreeCF());
		assertEquals(packs, packBusiness.getMinPackCombination(MockProduct.mockProductCF().getPacks(), 13));
	}
	
}
