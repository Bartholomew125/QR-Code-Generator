package Exceptions;

/**
 * InvalidVersionForAlignmentPatternException is a class that extends Exception.
 * This exception is used whenever the QR code version is 1, but an alignment
 * pattern is trying to be found for it. This is because the only QR code
 * version that doesn't have alignment patterns is version 1.
 */
public class InvalidVersionForAlignmentPatternException extends Exception {
    
    public InvalidVersionForAlignmentPatternException(int version) {
        super("Invalid version "+version+" for alignment pattern.");
    }
}
