package Exceptions;

/**
 * InvalidMaskPatternException is a class that extends Exception. This exception
 * is to be used whenever an attempt is made to use a mask pattern outside the
 * predefined range.
 */
public class InvalidMaskPatternException extends Exception {

    public InvalidMaskPatternException() {
        super("Invalid mask pattern. Must be between 1 and 7 inclusive.");
    }
    
}
