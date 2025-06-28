package Exceptions;

/**
 * InvalidVersionException is a class that extends Exception. This exception is
 * to be used whenever an invalid QR code version is used. The only valid QR
 * code version are 1 through 40.
 */
public class InvalidVersionException extends Exception {

    public InvalidVersionException() {
        super("Invalid QR code version. Must be between 1 and 40 inclusive.");
    }
}
