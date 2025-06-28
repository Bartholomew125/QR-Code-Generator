package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import Exceptions.InvalidVersionException;
import Tables.CharacterCapacityTable;
import Types.EncodingMode;
import Types.ErrorCorrectionLevel;

public class CharacterCapacityTableTest {
    
    @Test
    public void testCharacterCapacitiyTable() throws Exception {
        CharacterCapacityTable cct = new CharacterCapacityTable();
        assertEquals(cct.get(1, ErrorCorrectionLevel.L, EncodingMode.Numeric), 41);
        assertEquals(cct.get(10, ErrorCorrectionLevel.H, EncodingMode.Byte), 119);
        assertEquals(cct.get(20, ErrorCorrectionLevel.Q, EncodingMode.Alphanumeric), 702);
        assertEquals(cct.get(30, ErrorCorrectionLevel.M, EncodingMode.Numeric), 3289);
        assertEquals(cct.get(40, ErrorCorrectionLevel.H, EncodingMode.Numeric), 3057);
        assertEquals(cct.get(40, ErrorCorrectionLevel.H, EncodingMode.Alphanumeric), 1852);
        assertEquals(cct.get(40, ErrorCorrectionLevel.H, EncodingMode.Byte), 1273);
        assertEquals(cct.get(40, ErrorCorrectionLevel.H, EncodingMode.Kanji), 784);
        assertEquals(cct.get(ErrorCorrectionLevel.H, EncodingMode.Numeric, 2000), 32);
        assertEquals(cct.get(ErrorCorrectionLevel.L, EncodingMode.Byte, 500), 15);
        assertEquals(cct.get(ErrorCorrectionLevel.Q, EncodingMode.Alphanumeric, 200), 10);
        assertEquals(cct.get(ErrorCorrectionLevel.H, EncodingMode.Kanji, 666), 37);
    }

    @Test
    public void testCharacterCapacitiyTableException() {
        CharacterCapacityTable cct = new CharacterCapacityTable();
        assertThrows(InvalidVersionException.class, () -> cct.get(0, ErrorCorrectionLevel.L, EncodingMode.Numeric));
        assertThrows(InvalidVersionException.class, () -> cct.get(41, ErrorCorrectionLevel.L, EncodingMode.Numeric));
    }
}
