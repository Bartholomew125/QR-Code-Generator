package Encoders;

import Util.BitPadder;
import Util.Converter;

/**
 * NumericEncoder is a class that is used to encode numeric data.
 */
public class NumericEncoder {
    
    /**
     * Returns the encoded data.
     */
    public static String encode(String data) {
        // Put data into groups
        String[] groups = new String[(data.length()+2)/3];
        for (int i = 0; i < groups.length; i++) {
            groups[i] = "";
        }
        int groupIndex = 0;
        for (int i = 0; i < data.length(); i++) {
            groups[groupIndex] += data.substring(i, i+1);
            if (i%3 == 2) {
                groupIndex++;
            }
        }
        // Remove leading zeros in groups
        int[] finalGroups = new int[groups.length];
        for (int i = 0; i < finalGroups.length; i++) {
            finalGroups[i] = Integer.valueOf(groups[i]);
        }
        // Convert to binary
        String result = "";
        for (int group : finalGroups) {
            String bits = Converter.decimalToBinary(group);
            if (group < 10) {
                result += BitPadder.leftPadZero(bits, 4);
            }
            else if (group < 100) {
                result += BitPadder.leftPadZero(bits, 7);
            }
            else {
                result += BitPadder.leftPadZero(bits, 10);
            }
        }
        return result;
    }
}
