package Util;

import Exceptions.InvalidVersionException;
import Tables.BlockInformationTable;
import Types.EncodingMode;
import Types.ErrorCorrectionLevel;

/**
 * Utility is a class that holds miscellaneou methods for adding or modifying.
 * stuff.
 */
public class Utility {
    
    /**
     * Add terminator zeros to the given bits, given the right version and error
     * correction level. Terminator zeros are added if the bitstring is smaller
     * than the required length. A maximum of 4 zeros will are added.
     */
    public static String addTerminatorZeros(String bits, int version, ErrorCorrectionLevel errorCorrectionLevel) throws Exception {
        BlockInformationTable bit = new BlockInformationTable();
        int requiredNumBits = 8*bit.getTotalCodewords(version, errorCorrectionLevel);
        int actualNumBits = bits.length();
        int difference = requiredNumBits - actualNumBits;
        if (difference > 0) {
            if (difference >= 4) {
                bits = BitPadder.rightPadZero(bits, actualNumBits+4);
            }
            else {
                bits = BitPadder.rightPadZero(bits, actualNumBits+difference);
            }
        }
        return bits;
    }

    /**
     * Returns the mode string indicator given the encoding mode.
     */
    public static String generateModeIndicator(EncodingMode encodingMode) {
        switch (encodingMode) {
            case Numeric:
                return "0001";
            case Alphanumeric:
                return "0010";
            case Byte:
                return "0100";
            case Kanji:
                return "1000";
            default:
                return "0111";
        }
    }

    /**
     * Returns the character count indicator given the data, the version and encoding mode.
     */
    public static String generateCharacterCountIndicator(String data, int version, EncodingMode encodingMode) throws Exception {
        if (version < 1 || version > 40) {
            throw new InvalidVersionException();
        }
        String bits = Converter.decimalToBinary(data.length());
        int desiredLength = -1;
        if (version >= 1 && version <= 9) {
            switch (encodingMode) {
                case Numeric:
                    desiredLength = 10;
                    break;
                case Alphanumeric:
                    desiredLength = 9;
                    break;
                case Byte:
                    desiredLength = 8;
                    break;
                case Kanji:
                    desiredLength = 8;
                    break;
            }
        }
        else if (version >= 10 && version <= 26) {
            switch (encodingMode) {
                case Numeric:
                    desiredLength = 12;
                    break;
                case Alphanumeric:
                    desiredLength = 11;
                    break;
                case Byte:
                    desiredLength = 16;
                    break;
                case Kanji:
                    desiredLength = 10;
                    break;
            }
        }
        else {
            switch (encodingMode) {
                case Numeric:
                    desiredLength = 14;
                    break;
                case Alphanumeric:
                    desiredLength = 13;
                    break;
                case Byte:
                    desiredLength = 16;
                    break;
                case Kanji:
                    desiredLength = 12;
                    break;
            }
        }
        return BitPadder.leftPadZero(bits, desiredLength);
    }

    /**
     * Makes the given bit strings length a multiple of 8 by padding with zeros on the right side of it.
     */
    public static String makeMultipleOf8(String bits) {
        int currentLength = bits.length();
        int requiredZeros = (8-currentLength%8)%8;
        return BitPadder.rightPadZero(bits, requiredZeros+currentLength);
    }
}
