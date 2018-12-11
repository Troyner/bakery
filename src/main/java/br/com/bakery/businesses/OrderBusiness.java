package br.com.bakery.businesses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bakery.dtos.InputOrderDTO;
import br.com.bakery.dtos.OutputOrderDTO;
import br.com.bakery.dtos.PackDTO;
import br.com.bakery.entities.Pack;
import br.com.bakery.exceptions.EmptyParametersException;
import br.com.bakery.exceptions.FindException;
import br.com.bakery.exceptions.InvalidQuantityException;
import br.com.bakery.exceptions.NoPackCombinationException;

/**
 * Class responsible for being the business 
 * implementation of processes related to Order.
 * @author marcus.martins
 */
@Component
public class OrderBusiness {
	
	@Autowired
	private ProductBusiness productBusiness;
	
	@Autowired
	private PackBusiness packBusiness;
	
	/**
	 * Order packs of products, basing at quantity of the products
	 * passed. 
	 * @param inputs
	 * @return List<OutputOrderDTO>
	 * @throws FindException
	 * @throws NoPackCombinationException
	 * @throws EmptyParametersException
	 * @throws InvalidQuantityException
	 */
	public List<OutputOrderDTO> order(List<InputOrderDTO> inputs) throws FindException, NoPackCombinationException, EmptyParametersException, InvalidQuantityException {
		try {
			if (inputs == null || inputs.isEmpty()) {
				throw new EmptyParametersException("Order with no products");
			}
			
			List<OutputOrderDTO> outputs = new ArrayList<>();
			
			for (InputOrderDTO input : inputs) {
				List<Pack> packs = this.productBusiness.findPacksByProductCode(input.getProductCode());
				
				List<PackDTO> packsDTO = this.packBusiness.getMinPackCombination(packs, input.getProductQuantity());
				
				outputs.add(OutputOrderDTO.builder()
						.productQuantity(input.getProductQuantity())
						.productCode(input.getProductCode())
						.productTotalCost(sumTotalCost(packsDTO))
						.packs(packsDTO)
						.build());
			}
			
			return outputs;
		} catch (FindException | NoPackCombinationException | EmptyParametersException | InvalidQuantityException e) {
			throw e;
		} catch (Exception e) {
			throw new FindException("Unknown error at the order", e);
		}
	}
	
	/**
	 * Sum all product costs of a pack.
	 * @param packsDTO
	 * @return Double
	 */
	private Double sumTotalCost(List<PackDTO> packsDTO) {
		return packsDTO.stream().map(PackDTO::getPackCost).collect(Collectors.summarizingDouble(Double::doubleValue)).getSum();
	}
}
