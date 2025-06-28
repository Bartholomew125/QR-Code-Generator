package Tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import Exceptions.InvalidVersionException;
import Exceptions.InvalidVersionForAlignmentPatternException;
import Tables.AlignmentPatternLocationsTable;

public class AlignmentPatternLocationsTableTest {
    
    @Test
    public void testAlignmentPatternLocationsTable() throws Exception {
        AlignmentPatternLocationsTable aplt = new AlignmentPatternLocationsTable();
        assertArrayEquals(aplt.get(2), new int[]{6,18});
        assertArrayEquals(aplt.get(10), new int[]{6, 28, 50});
        assertArrayEquals(aplt.get(20), new int[]{6, 34, 62, 90});
        assertArrayEquals(aplt.get(30), new int[]{6, 26, 52, 78, 104, 130});
        assertArrayEquals(aplt.get(40), new int[]{6, 30, 58, 86, 114, 142, 170});
    }

    @Test
    public void testAlignmentPatternLocationsTableException() {
        AlignmentPatternLocationsTable aplt = new AlignmentPatternLocationsTable();
        assertThrows(InvalidVersionException.class, () -> aplt.get(0));
        assertThrows(InvalidVersionForAlignmentPatternException.class, () -> aplt.get(1));
    }
}
