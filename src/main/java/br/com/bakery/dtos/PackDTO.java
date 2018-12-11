package br.com.bakery.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

/**
 * Packs of output order.
 * @author marcus.martins
 *
 */
public class PackDTO {
	
	private Integer packQuantity;
	private Integer productQuantity;
	private Double packCost;
	
}
