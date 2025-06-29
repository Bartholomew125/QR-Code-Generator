package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import Exceptions.InvalidVersionException;
import Tables.ErrorCorrectionCodeWordsTable;
import Types.ErrorCorrectionLevel;

public class ErrorCorrectionCodeWordsTableTest {
    
    @Test
    public void testErrorCorrectionCodeWordsTable() throws Exception {
        ErrorCorrectionCodeWordsTable ecct = new ErrorCorrectionCodeWordsTable();
        assertEquals(ecct.get(1, ErrorCorrectionLevel.L), 7);
        assertEquals(ecct.get(10, ErrorCorrectionLevel.M), 26);
        assertEquals(ecct.get(20, ErrorCorrectionLevel.L), 28);
        assertEquals(ecct.get(30, ErrorCorrectionLevel.H), 30);
        assertEquals(ecct.get(40, ErrorCorrectionLevel.L), 30);
    }

    @Test
    public void testErrorCorrectionCodeWordsTableException() {
        ErrorCorrectionCodeWordsTable ecct = new ErrorCorrectionCodeWordsTable();
        assertThrows(InvalidVersionException.class, () -> ecct.get(0, ErrorCorrectionLevel.L));
        assertThrows(InvalidVersionException.class, () -> ecct.get(41, ErrorCorrectionLevel.L));
    }
}
