package br.com.bakery.exceptions;

/**
 * Exception to deal with order erros, that 
 * will be handled by ApiExceptionHandler.
 * @author marcus.martins
 */
public class OrderException extends Exception {
	private static final long serialVersionUID = 1L;

	public OrderException(String message) {
        super(message);
    }
	
	public OrderException(String message, Exception exception) {
        super(message, exception);
    }
}
