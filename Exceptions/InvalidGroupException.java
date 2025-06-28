package Exceptions;

/**
 * InvalidGroupException is a class that extends Exception. This exception is to
 * be thrown whenever a group other than 1 or 2 is used.
 */
public class InvalidGroupException extends Exception {
    
    public InvalidGroupException() {
        super("Invalid group argument. Must be either 1 or 2.");
    }
}
