package br.com.bakery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bakery.businesses.OrderBusiness;
import br.com.bakery.dtos.InputOrderDTO;
import br.com.bakery.dtos.OutputOrderDTO;
import br.com.bakery.exceptions.FindException;
import br.com.bakery.exceptions.OrderException;
import br.com.bakery.formatters.OrderFormatter;

/**
 * Class responsible for being the implementation of the methods that will receive the requests of Card.
 * 
 * @author marcus.martins
 * @since 08/02/2018 
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderBusiness business;

    /**
     * Methods responsible for calling the business order in a JSON format.
     * @return ResponseEntity<String>
     * @throws FindException 
     */
    @RequestMapping(value="/order", method = RequestMethod.POST)
    public ResponseEntity<String> order(@RequestBody String input) throws OrderException {
    	try {
    		return ResponseEntity.ok(OrderFormatter.responseFormat(this.business.order(OrderFormatter.resquestFormat(input))));
    	} catch (Exception e) {
			throw new OrderException(e.getMessage(), e);
		}
		
    }
    
    /**
     * Methods responsible for calling the business order in a text format.
     * @return ResponseEntity<String>
     * @throws FindException 
     */
    @RequestMapping(value="/order-json", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OutputOrderDTO>> orderJson(@RequestBody List<InputOrderDTO> inputs) throws OrderException {
    	try {
    		return ResponseEntity.ok(this.business.order(inputs));
    	} catch (Exception e) {
			throw new OrderException(e.getMessage(), e);
		}
		
    }
    
}
