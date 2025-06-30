package Encoders;

import Tables.AlphanumericTable;
import Util.BitPadder;
import Util.Converter;

/**
 * AlphanumericEncoder is a class that is used for encoding data in alphanumeric
 * encoding mode.
 * 
 * @see <a href=
 *      "https://www.thonky.com/qr-code-tutorial/alphanumeric-mode-encoding">Thonky's
 *      QR Code Tutorial</a>
 */
public class AlphanumericEncoder {

    private static final AlphanumericTable TABLE = new AlphanumericTable();

    /**
     * Returns the data encoded using alpha numeric encoding.
     */
    public static String encode(String data) throws Exception {
        String result = "";
        int num = 0;
        for (int i = 0; i < data.length()-3; i = i + 2) {
            num = TABLE.get(data.substring(i,i+1));
            num = num*45 + TABLE.get(data.substring(i+1,i+2));
            result = result + BitPadder.leftPadZero(Converter.decimalToBinary(num), 11);
        }
        if (data.length()%2 == 0) {
            num = TABLE.get(data.substring(data.length()-2, data.length()-1));
            num = num*45 + TABLE.get(data.substring(data.length()-1,data.length()));
            result = result + BitPadder.leftPadZero(Converter.decimalToBinary(num), 11);
        }
        else {
            num = TABLE.get(data.substring(data.length()-1, data.length()));
            result = result + BitPadder.leftPadZero(Converter.decimalToBinary(num), 6);
        }
        return result;
    }
}
