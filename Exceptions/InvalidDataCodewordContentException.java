package Exceptions;

/**
 * InvalidDataCodewordContentException is a class that extends Exception. It is
 * thrown whenever a DataCodeword does not consist solely of 1's and 0's.
 */
public class InvalidDataCodewordContentException extends Exception {
    
    public InvalidDataCodewordContentException() {
        super();
    }
}
