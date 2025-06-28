package Exceptions;

/**
 * InvalidencodingModeException is class that extends Exception. This exception is to be used whenever an encoding mode is seen that doesn't fit the checked encoding modes.
 */
public class InvalidEncodingModeException extends Exception {

    public InvalidEncodingModeException() {
        super("The given encoding mode is not valid or unknown.");
    }
}
