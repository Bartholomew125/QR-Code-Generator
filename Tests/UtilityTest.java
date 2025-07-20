package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Types.EncodingMode;
import Types.ErrorCorrectionLevel;
import Util.Utility;

public class UtilityTest {

    @Test
    public void testUtilityAddTerminatorZeros() throws Exception {
        assertEquals(Utility.addTerminatorZeros("0", 1, ErrorCorrectionLevel.H), "0"+"0000");
        assertEquals(Utility.addTerminatorZeros("1", 5, ErrorCorrectionLevel.L), "1"+"0000");
        assertEquals(Utility.addTerminatorZeros("1".repeat(8*8)+"11111", 1, ErrorCorrectionLevel.H), "1".repeat(8*8)+"11111000");
        assertEquals(Utility.addTerminatorZeros("1".repeat(8*1275), 25, ErrorCorrectionLevel.L), "1".repeat(8*1275)+"0000");
        assertEquals(Utility.addTerminatorZeros("1".repeat(8*1276),40, ErrorCorrectionLevel.H), "1".repeat(8*1276));
    }

    @Test
    public void testUtilityGenerateModeIndicator() {
        assertEquals(Utility.generateModeIndicator(EncodingMode.Numeric), "0001");
        assertEquals(Utility.generateModeIndicator(EncodingMode.Alphanumeric), "0010");
        assertEquals(Utility.generateModeIndicator(EncodingMode.Byte), "0100");
        assertEquals(Utility.generateModeIndicator(EncodingMode.Kanji), "1000");
    }

    @Test
    public void testUtilityGenerateCharacterCountIndicator() throws Exception {
        assertEquals(Utility.generateCharacterCountIndicator("HELLO WORLD", 1, EncodingMode.Alphanumeric), "000001011");
        assertEquals(Utility.generateCharacterCountIndicator("TesttestTest", 10, EncodingMode.Byte), "0000000000001100");
        assertEquals(Utility.generateCharacterCountIndicator("", 20, EncodingMode.Kanji), "0000000000");
        assertEquals(Utility.generateCharacterCountIndicator("1234567890", 30, EncodingMode.Numeric), "00000000001010");
    }
    
    
}
