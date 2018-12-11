package br.com.bakery.exceptions;

/**
 * Exception to deal with invalid quantity.
 * @author marcus.martins
 */
public class InvalidQuantityException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidQuantityException(String message) {
        super(message);
    }
	
	public InvalidQuantityException(String message, Exception exception) {
        super(message, exception);
    }
}
