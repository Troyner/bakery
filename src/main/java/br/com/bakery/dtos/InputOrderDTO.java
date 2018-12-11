package br.com.bakery.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

/**
 * Input of a order.
 * @author marcus.martins
 *
 */
public class InputOrderDTO {

	private Integer productQuantity;
	private String productCode;
	
}
