package br.com.bakery.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

/**
 * Output of a order.
 * @author marcus.martins
 *
 */
public class OutputOrderDTO {

	private Integer productQuantity;
	private String productCode;
	private Double productTotalCost;
	private List<PackDTO> packs;
	
}
