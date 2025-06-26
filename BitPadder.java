/**
 * BitPadder is a class that is responsible for padding bitstrings with zeros or
 * ones on the left or right side.
 */
public class BitPadder {
    
    /**
     * Pads the given bitString with zeros on the left untill it is the desired
     * length.
     */
    public static String leftPadZero(String bitString, int desiredLength) {
        if (bitString.length() >= desiredLength) {
            return bitString;
        }
        else {
            String newBitString = "0" + bitString;
            return leftPadZero(newBitString, desiredLength);
        }
    }
}
