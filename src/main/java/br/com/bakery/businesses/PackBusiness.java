
package br.com.bakery.businesses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.bakery.dtos.PackDTO;
import br.com.bakery.entities.Pack;
import br.com.bakery.exceptions.EmptyParametersException;
import br.com.bakery.exceptions.InvalidQuantityException;
import br.com.bakery.exceptions.NoPackCombinationException;

/**
 * Class responsible for being the business 
 * implementation of processes related to Pack.
 * @author marcus.martins
 */
@Component
public class PackBusiness {

	/**
	 * Get the minimal combination of packs
	 * according to the products passed 
	 * @param packs
	 * @param productQuantity
	 * @return List<PackDTO>
	 * @throws NoPackCombinationException
	 * @throws EmptyParametersException
	 * @throws InvalidQuantityException
	 */
	public List<PackDTO> getMinPackCombination(List<Pack> packs, Integer productQuantity) throws NoPackCombinationException, EmptyParametersException, InvalidQuantityException {
		
		validateParameters(packs, productQuantity);
		
		List<PackDTO> packsDTO = new ArrayList<>();
		
		Map<Integer, Double> map = getMap(packs);
		
		if (map.containsKey(productQuantity)) {
			packsDTO.add(buildPackDTO(1, productQuantity, map.get(productQuantity)));
			return packsDTO;
		}
		
		List<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys, Collections.reverseOrder());
		Integer minKey = Collections.min(keys);
		
		while (!keys.isEmpty()) {
			packsDTO.clear();
			Integer amountMissing = productQuantity;
			Integer cacheAmountMissing = amountMissing;
			for (Integer key : keys) {
				
				cacheAmountMissing = amountMissing;

				if (amountMissing < key) {
					continue;
				}
				
				if (keys.contains(amountMissing)) {
					packsDTO.add(buildPackDTO(1, key, map.get(key)));
					return packsDTO;
				} if (key <= amountMissing) {
					amountMissing = amountMissing - key;
					int count = 1;
					while (key <= amountMissing) {
						count++;
						amountMissing = amountMissing - key;
					}
					
					packsDTO.add(buildPackDTO(count, key, map.get(key)));
				}
				
				if (amountMissing == 0) {
					return packsDTO;
				} else if (amountMissing < minKey) {
					amountMissing = cacheAmountMissing;
					packsDTO.remove(packsDTO.size() - 1);
				}
			}
			keys.remove(keys.get(0));
		}
		
		throw new NoPackCombinationException("No pack combination found");
	}

	/**
	 * Validate input parameters
	 * @param packs
	 * @param productQuantity
	 * @throws EmptyParametersException
	 * @throws InvalidQuantityException
	 */
	private void validateParameters(List<Pack> packs, Integer productQuantity) throws EmptyParametersException, InvalidQuantityException {
		if (packs == null || packs.isEmpty()) {
			throw new EmptyParametersException("Product with no packs");
		} else if (productQuantity == null || productQuantity <= 0) {
			throw new InvalidQuantityException("Invalid quantity of products");
		}
	}
	
	/**
	 * Get a map for a cloned list of packs,
	 * @param packs
	 * @return Map<Integer, Double>
	 */
	@SuppressWarnings("unchecked")
	private Map<Integer, Double> getMap(List<Pack> packs) {
		ArrayList<Pack> packsToClone = new ArrayList<>();
		packsToClone.addAll(packs);
		return convertToMap((ArrayList<Pack>) packsToClone.clone());
	}
	
	/**
	 * Convert map to a list of packs.
	 * @param packs
	 * @return Map<Integer, Double>
	 */
	private Map<Integer, Double> convertToMap(ArrayList<Pack> list) {
		return list.stream().collect(Collectors.toMap(Pack::getProductQuantity, Pack::getPackCost));
	}
	
	private PackDTO buildPackDTO(Integer packQuantity, Integer productQuantity, Double packCost) {
		return PackDTO.builder()
				.packCost(packCost)
				.packQuantity(packQuantity)
				.productQuantity(productQuantity)
				.build();
	}
}
