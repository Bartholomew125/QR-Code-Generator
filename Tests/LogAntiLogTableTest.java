package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import Tables.LogAntiLogTable;

public class LogAntiLogTableTest {
    
    @Test
    public void testLogAntiLogTable() throws Exception {
        LogAntiLogTable lalt = new LogAntiLogTable();
        assertEquals(lalt.getLog(0), 1);
        assertEquals(lalt.getLog(20), 180);
        assertEquals(lalt.getLog(80), 253);
        assertEquals(lalt.getLog(140), 132);
        assertEquals(lalt.getLog(255), 1);
        assertEquals(lalt.getAntiLog(1), 0);
        assertEquals(lalt.getAntiLog(20), 52);
        assertEquals(lalt.getAntiLog(80), 54);
        assertEquals(lalt.getAntiLog(140), 49);
        assertEquals(lalt.getAntiLog(255), 175);
    }

    @Test
    public void testLogAntiLogTableException() {
        LogAntiLogTable lalt = new LogAntiLogTable();
        assertThrows(Exception.class, () -> lalt.getLog(-1));
        assertThrows(Exception.class, () -> lalt.getLog(256));
        assertThrows(Exception.class, () -> lalt.getAntiLog(0));
        assertThrows(Exception.class, () -> lalt.getAntiLog(256));
    }
}
