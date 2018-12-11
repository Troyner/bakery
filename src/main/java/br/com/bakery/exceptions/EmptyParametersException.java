package br.com.bakery.exceptions;

/**
 * Exception to deal with empty parameters.
 * @author marcus.martins
 */
public class EmptyParametersException extends Exception {
	private static final long serialVersionUID = 1L;

	public EmptyParametersException(String message) {
        super(message);
    }
	
	public EmptyParametersException(String message, Exception exception) {
        super(message, exception);
    }
}
