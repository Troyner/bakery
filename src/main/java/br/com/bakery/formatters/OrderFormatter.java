package br.com.bakery.formatters;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.bakery.dtos.InputOrderDTO;
import br.com.bakery.dtos.OutputOrderDTO;
import br.com.bakery.dtos.PackDTO;
import br.com.bakery.exceptions.EmptyParametersException;

public class OrderFormatter {

	/**
	 * Format a request of input to String.
	 * @param request
	 * @return List<InputOrderDTO>
	 * @throws EmptyParametersException
	 */
	public static List<InputOrderDTO> resquestFormat(String request) throws EmptyParametersException {
		try {
			String[] lines = request.split("\\n");
			
			List<InputOrderDTO> inputs = new ArrayList<>();
			
			for (String line : lines) {
				String[] properties = line.trim().split(" ");
				inputs.add(InputOrderDTO.builder()
						.productQuantity(Integer.parseInt(properties[0]))
						.productCode(properties[1])
						.build());
			}
			
			return inputs;
		} catch (Exception e) {
			throw new EmptyParametersException("Invalid order", e);
		}
	}
	
	/**
	 * Format a response of output to String.
	 * @param response
	 * @return String
	 */
	public static String responseFormat(List<OutputOrderDTO> response) {
		StringBuilder stringBuilder = new StringBuilder();
		
		String whitespace = " ";
		
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		
		for (OutputOrderDTO output : response) {
			stringBuilder.append(output.getProductQuantity())
				.append(whitespace)
				.append(output.getProductCode())
				.append(whitespace)
				.append("$")
				.append(decimalFormat.format(output.getProductTotalCost()));
				
			for (PackDTO packDTO : output.getPacks()) {
				stringBuilder.append("\n")
					.append(whitespace)
					.append(whitespace)
					.append(whitespace)
					.append(whitespace)
					.append(whitespace)
					.append(whitespace)
					.append(whitespace)
					.append(packDTO.getPackQuantity())
					.append(whitespace)
					.append("x")
					.append(whitespace)
					.append("$")
					.append(decimalFormat.format(packDTO.getPackCost()));
			}
			
			stringBuilder.append("\n");
		}
		
		return stringBuilder.toString();
	}
}
