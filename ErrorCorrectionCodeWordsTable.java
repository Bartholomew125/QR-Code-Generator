import java.util.Arrays;

import Exceptions.InvalidVersionException;
import Types.ErrorCorrectionLevel;

/**
 * ErrorCorrectionCodeWordsTable is a class that holds information about how
 * many error correction codewords there are per block for each version, and
 * error correction level.
 * 
 * @see <a href=
 *      "https://www.thonky.com/qr-code-tutorial/alignment-pattern-locations">Thonky's
 *      QR Code Tutorial</a>
 */
public class ErrorCorrectionCodeWordsTable {

    private int[] table;

    public ErrorCorrectionCodeWordsTable() {
        this.table = new int[]{7,10,13,17,10,16,22,28,15,26,18,22,20,18,26,16,
            26,24,18,22,18,16,24,28,20,18,18,26,24,22,22,26,30,22,20,24,18,26,
            24,28,20,30,28,24,24,22,26,28,26,22,24,22,30,24,20,24,22,24,30,24,
            24,28,24,30,28,28,28,28,30,26,28,28,28,26,26,26,28,26,30,28,28,26,
            28,30,28,28,30,24,30,28,30,30,30,28,30,30,26,28,30,30,28,28,28,30,
            30,28,30,30,30,28,30,30,30,28,30,30,30,28,30,30,30,28,30,30,30,28,
            30,30,30,28,30,30,30,28,30,30,30,28,30,30,30,28,30,30,30,28,30,30,
            30,28,30,30,30,28,30,30,30,28,30,30};
    }

    /**
     * Returns the number of error correction codewords per block given the
     * version and error correction level.
     */
    public int get(int version, ErrorCorrectionLevel errorCorrectionLevel) throws Exception {
        if (version < 1 || version > 40) {
            throw new InvalidVersionException();
        }
        int index = (version-1)*4 +
        Arrays.asList(ErrorCorrectionLevel.L, ErrorCorrectionLevel.M, ErrorCorrectionLevel.Q, ErrorCorrectionLevel.H).indexOf(errorCorrectionLevel);
        return this.table[index];
    }
}


