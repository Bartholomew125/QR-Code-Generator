package Util;

import Tables.BlockInformationTable;
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

}
