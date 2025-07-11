package Tables;
import java.util.HashMap;

import Exceptions.InvalidMaskPatternException;
import Types.ErrorCorrectionLevel;

/**
 * FormatInformationBitsTable is a class that holds the bit strings that descibe
 * the format of the QR code. This includes which level of error correction
 * coding is used, and what mask pattern is used.
 * 
 * @see <a href=
 *      "https://www.thonky.com/qr-code-tutorial/format-version-tables">Thonky's
 *      QR Code Tutorial</a>
 */
public class FormatInformationBitsTable {

    private HashMap<ErrorCorrectionLevel, String[]> table;

    public FormatInformationBitsTable() {
        this.table = new HashMap<>();
        this.table.put(ErrorCorrectionLevel.L, 
            new String[]{
                "111011111000100",
                "111001011110011",
                "111110110101010",
                "111100010011101",
                "110011000101111",
                "110001100011000",
                "110110001000001",
                "110100101110110"
            }
        );
        this.table.put(ErrorCorrectionLevel.M, 
            new String[]{
                "101010000010010",
                "101000100100101",
                "101111001111100",
                "101101101001011",
                "100010111111001",
                "100000011001110",
                "100111110010111",
                "100101010100000"
            }
        );
        this.table.put(ErrorCorrectionLevel.Q, 
            new String[]{
                "011010101011111",
                "011000001101000",
                "011111100110001",
                "011101000000110",
                "010010010110100",
                "010000110000011",
                "010111011011010",
                "010101111101101"
            }
        );
        this.table.put(ErrorCorrectionLevel.H, 
            new String[]{
                "001011010001001",
                "001001110111110",
                "001110011100111",
                "001100111010000",
                "000011101100010",
                "000001001010101",
                "000110100001100",
                "000100000111011"
            }
        );
    }

    /**
     * Returns the format information bits given the error correction level, and
     * the mask pattern.
     */
    public String get(ErrorCorrectionLevel errorCorrectionLevel, int maskPattern) throws Exception {
        if (maskPattern > 7 || maskPattern < 0) {
            throw new InvalidMaskPatternException();
        }
        return this.table.get(errorCorrectionLevel)[maskPattern];
    }
}


