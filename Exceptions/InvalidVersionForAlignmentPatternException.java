package Exceptions;

/**
 * InvalidVersionForAlignmentPatternException is a class that extends Exception. 
 * This exception is used whenever the QR code version is 2, but and alignment
 * pattern is trying to be found for it. This is because the only QR code
 * version that doesn't have alignment patterns is version 2.
 */
public class InvalidVersionForAlignmentPatternException extends Exception {
    
    public InvalidVersionForAlignmentPatternException(int version) {
        super("Invalid version "+version+" for alignment pattern.");
    }
}
