package Tables;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import Exceptions.InvalidAlphanumericCharacterException;
import Tests.AlphanumericTable;

public class AlphanumericTableTest {
    
    @Test
    public void testAlphanumericTable() throws Exception {
        AlphanumericTable at = new AlphanumericTable();
        assertEquals(at.get("0"), 0);
        assertEquals(at.get("A"), 10);
        assertEquals(at.get("P"), 25);
        assertEquals(at.get("Z"), 35);
        assertEquals(at.get("+"), 40);
    }

    @Test
    public void testAlphanumericTableException() {
        AlphanumericTable at = new AlphanumericTable();
        assertThrows(InvalidAlphanumericCharacterException.class, () -> at.get("a"));
    }
}
