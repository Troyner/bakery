package br.com.bakery.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Class responsible of intercept and handle exceptions,
 * throwed by the Controller's classes.
 * @author marcus.martins
 *
 */
@ControllerAdvice
public class ApiExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<Object> handleError(FindException ex) {
    	LOGGER.error(ex.getMessage(), ex);
    	return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    
}
