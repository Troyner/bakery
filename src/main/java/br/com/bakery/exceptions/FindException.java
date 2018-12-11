package br.com.bakery.exceptions;

/**
 * Exception to deal with queries erros, that 
 * will be handled by ApiExceptionHandler.
 * @author marcus.martins
 */
public class FindException extends Exception {
	private static final long serialVersionUID = 1L;

	public FindException(String message) {
        super(message);
    }
	
	public FindException(String message, Exception exception) {
        super(message, exception);
    }
}
