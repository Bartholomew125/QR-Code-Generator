package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import Tables.VersionInformationBitsTable;

public class VersionInformationBitsTableTest {
    
    @Test
    public void testVersionInformationBitsTable() throws Exception {
        VersionInformationBitsTable vibt = new VersionInformationBitsTable();
        assertEquals(vibt.get(7), "000111110010010100");
        assertEquals(vibt.get(10), "001010010011010011");
        assertEquals(vibt.get(20), "010100100110100110");
        assertEquals(vibt.get(30), "011110110101110101");
        assertEquals(vibt.get(40), "101000110001101001");
    }

    @Test public void testVersionInformationBitsTableException() {
        VersionInformationBitsTable vibt = new VersionInformationBitsTable();
        assertThrows(Exception.class, () -> vibt.get(6));
        assertThrows(Exception.class, () -> vibt.get(41));
    }
}