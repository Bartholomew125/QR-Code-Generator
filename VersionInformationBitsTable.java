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
        this.table = new String[35];
        this.table[0] = "000111110010010100";
        this.table[1] = "000111110010010100";
        this.table[2] = "001000010110111100";
        this.table[3] = "001001101010011001";
        this.table[4] = "001010010011010011";
        this.table[5] = "001011101111110110";
        this.table[6] = "001100011101100010";
        this.table[7] = "001101100001000111";
        this.table[8] = "001110011000001101";
        this.table[9] = "001111100100101000";
        this.table[10] = "010000101101111000";
        this.table[11] = "010001010001011101";
        this.table[12] = "010010101000010111";
        this.table[13] = "010011010100110010";
        this.table[14] = "010100100110100110";
        this.table[15] = "010101011010000011";
        this.table[16] = "010110100011001001";
        this.table[17] = "010111011111101100";
        this.table[18] = "011000111011000100";
        this.table[19] = "011001000111100001";
        this.table[20] = "011010111110101011";
        this.table[21] = "011011000010001110";
        this.table[22] = "011100110000011010";
        this.table[23] = "011101001100111111";
        this.table[24] = "011110110101110101";
        this.table[25] = "011111001001010000";
        this.table[26] = "100000100111010101";
        this.table[27] = "100001011011110000";
        this.table[28] = "100010100010111010";
        this.table[29] = "100011011110011111";
        this.table[30] = "100100101100001011";
        this.table[31] = "100101010000101110";
        this.table[32] = "100110101001100100";
        this.table[33] = "100111010101000001";
        this.table[34] = "101000110001101001";
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


