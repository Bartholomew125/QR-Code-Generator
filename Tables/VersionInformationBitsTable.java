package Tables;
/**
 * VersionInformationBitsTable is a class that stores a bit string for each QR
 * code version greater than or equal to 7, which represents that version.
 * 
 * @see <a href=
 *      "https://www.thonky.com/qr-code-tutorial/format-version-tables">Thonky's
 *      QR Code Tutorial</a>
 */
public class VersionInformationBitsTable {

    private String[] table;

    public VersionInformationBitsTable() {
        this.table = new String[]{"000111110010010100","001000010110111100",
             "001001101010011001","001010010011010011","001011101111110110",
             "001100011101100010","001101100001000111","001110011000001101",
             "001111100100101000","010000101101111000","010001010001011101",
             "010010101000010111","010011010100110010","010100100110100110",
             "010101011010000011","010110100011001001","010111011111101100",
             "011000111011000100","011001000111100001","011010111110101011",
             "011011000010001110","011100110000011010","011101001100111111",
             "011110110101110101","011111001001010000","100000100111010101",
             "100001011011110000","100010100010111010","100011011110011111",
             "100100101100001011","100101010000101110","100110101001100100",
             "100111010101000001","101000110001101001"};
    }

    /**
     * Returns the version informations bits for the given version.
     */
    public String get(int version) throws Exception {
        if (version < 7 || version > 40) {
            throw new Exception("Version must be between 7 and 40, but was "+version);
        }
        return this.table[version-7];
    }
}


