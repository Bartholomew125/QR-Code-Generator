package Encoders;

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
            result = result + Converter.decimalToBinary(group);
        }
        return result;
    }
}
