package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import Exceptions.InvalidMaskPatternException;
import Tables.FormatInformationBitsTable;
import Types.ErrorCorrectionLevel;

public class FormatInformationBitsTableTest {

    @Test
    public void testFormatInformationBitsTable() throws Exception {
        FormatInformationBitsTable fibt = new FormatInformationBitsTable();
        assertEquals(fibt.get(ErrorCorrectionLevel.L, 0), "111011111000100");
        assertEquals(fibt.get(ErrorCorrectionLevel.M, 3), "101101101001011");
        assertEquals(fibt.get(ErrorCorrectionLevel.H, 4), "000011101100010");
        assertEquals(fibt.get(ErrorCorrectionLevel.H, 6), "000110100001100");
        assertEquals(fibt.get(ErrorCorrectionLevel.M, 7), "100101010100000");
    }

    @Test
    public void testFormatInformationBitsTableException() {
        FormatInformationBitsTable fibt = new FormatInformationBitsTable();
        assertThrows(InvalidMaskPatternException.class, () -> fibt.get(ErrorCorrectionLevel.L, -1));
        assertThrows(InvalidMaskPatternException.class, () -> fibt.get(ErrorCorrectionLevel.L, 8));
    }
}