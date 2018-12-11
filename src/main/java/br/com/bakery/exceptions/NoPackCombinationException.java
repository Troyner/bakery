package br.com.bakery.exceptions;

/**
 * Exception to deal with wrong pack combination at
 * the process to get min pack combination.
 * @author marcus.martins
 */
public class NoPackCombinationException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoPackCombinationException(String message) {
        super(message);
    }
	
	public NoPackCombinationException(String message, Exception exception) {
        super(message, exception);
    }
}
