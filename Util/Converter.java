package Util;
/**
 * Converter is a class that holds methods for converting between different
 * bases of numbers.
 */
public class Converter {
    
    /**
     * Converts a positive integer to a binary string.
     */
    public static String decimalToBinary(int decimal) {
        if (decimal == 0) { return "0"; }
        String binary = "";

        while (decimal > 0) {
            int remainder = decimal%2;
            binary = remainder + binary;
            decimal = decimal >> 1;
        }

        return binary;
    }
}
