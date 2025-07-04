package Util;
/**
 * BitPadder is a class that is responsible for padding bitstrings with zeros or
 * ones on the left or right side.
 */
public class BitPadder {
    
    /**
     * Pads the given bitString with zeros on the left until it is the desired
     * length.
     */
    public static String leftPadZero(String bitString, int desiredLength) {
        return BitPadder.padBits(bitString, desiredLength, "0", true);
    }

    /**
     * Pads the given bitString with zeros on the right until it is the desired
     * length.
     */
    public static String rightPadZero(String bitString, int desiredLength) {
        return BitPadder.padBits(bitString, desiredLength, "0", false);
    }


    /**
     * Pads the given bitString with the given pad bits, until it is the desired
     * length, on the left or right side.
     */
    public static String padBits(String bitString, int desiredLength, String padBits, boolean padLeftSide) {
        int bitStringLength = bitString.length();
        if (bitStringLength >= desiredLength) {
            return bitString;
        }
        int padBitsLength = padBits.length();
        int wholePadBitsNedded = (desiredLength-bitStringLength) / padBitsLength;
        int remainder = (desiredLength-bitStringLength) % padBitsLength;
        if (padLeftSide) {
            return padBits.substring(padBitsLength-remainder, padBitsLength) + padBits.repeat(wholePadBitsNedded) + bitString;
        }
        else {
            return bitString + padBits.repeat(wholePadBitsNedded) + padBits.substring(0, remainder);
        }
    }
}
