package Encoders;

import Util.BitPadder;

/**
 * ByteEncoder is a class that is responsible for encoding data using the byte encoding mode.
 */
public class ByteEncoder {
    
    /**
     * Returns the encoded data.
     */
    public static String encode(String data) {
        String result = "";
        for (byte b : data.getBytes()) {
            String binary = Integer.toBinaryString(b);
            result = result + BitPadder.leftPadZero(binary, 8);
        }
        return result;
    }
}
