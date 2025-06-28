package Exceptions;

/**
 * InvalidAlphanumericCharacterException is a class that extends Exception. This
 * exception is to be thrown whenever a character is used that is not an
 * alphanumeric character.
 */
public class InvalidAlphanumericCharacterException extends Exception {
    
    public InvalidAlphanumericCharacterException(String c) {
        super("The character "+c+" is not a valid alphanumeric character.");
    }
}
