package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.lang.System.Logger.Level;

import org.junit.Test;

import Exceptions.InvalidGroupException;
import Exceptions.InvalidVersionException;
import Tables.BlockInformationTable;
import Types.ErrorCorrectionLevel;

public class BlockInformationTableTest {
    
    @Test
    public void testBlockInformationTableGetBlocksInGroup() throws Exception {
        BlockInformationTable bit = new BlockInformationTable();
        assertEquals(bit.getBlocksInGroup(1, ErrorCorrectionLevel.M, 1), 1);
        assertEquals(bit.getBlocksInGroup(10, ErrorCorrectionLevel.L, 2), 2);
        assertEquals(bit.getBlocksInGroup(20, ErrorCorrectionLevel.Q, 1), 15);
        assertEquals(bit.getBlocksInGroup(30, ErrorCorrectionLevel.H, 2), 25);
        assertEquals(bit.getBlocksInGroup(40, ErrorCorrectionLevel.M, 2), 31);
        assertEquals(bit.getBlocksInGroup(1, ErrorCorrectionLevel.L, 2), 0);
    }

    @Test
    public void testBlockInformationTableGetCodewordsPerBlockInGroup() throws Exception {
        BlockInformationTable bit = new BlockInformationTable();
        assertEquals(bit.getCodewordsPerBlockInGroup(1, ErrorCorrectionLevel.M, 1), 16);
        assertEquals(bit.getCodewordsPerBlockInGroup(10, ErrorCorrectionLevel.L, 2), 69);
        assertEquals(bit.getCodewordsPerBlockInGroup(20, ErrorCorrectionLevel.Q, 1), 24);
        assertEquals(bit.getCodewordsPerBlockInGroup(30, ErrorCorrectionLevel.H, 2), 16);
        assertEquals(bit.getCodewordsPerBlockInGroup(40, ErrorCorrectionLevel.M, 2), 48);
        assertEquals(bit.getCodewordsPerBlockInGroup(1, ErrorCorrectionLevel.L, 2), 0);
    }

    @Test
    public void testBlockInformationTableGetBlocksInGroupException() {
        BlockInformationTable bit = new BlockInformationTable();
        assertThrows(InvalidVersionException.class, () -> bit.getBlocksInGroup(0, ErrorCorrectionLevel.L, 1));
        assertThrows(InvalidVersionException.class, () -> bit.getBlocksInGroup(41, ErrorCorrectionLevel.L, 1));
        assertThrows(InvalidGroupException.class, () -> bit.getBlocksInGroup(1, ErrorCorrectionLevel.L, 0));
        assertThrows(InvalidGroupException.class, () -> bit.getBlocksInGroup(1, ErrorCorrectionLevel.L, 3));
    }

    @Test
    public void testBlockInformationTableGetCodeworldsPerBlockInGroupException() {
        BlockInformationTable bit = new BlockInformationTable();
        assertThrows(InvalidVersionException.class, () -> bit.getCodewordsPerBlockInGroup(0, ErrorCorrectionLevel.L, 1));
        assertThrows(InvalidVersionException.class, () -> bit.getCodewordsPerBlockInGroup(41, ErrorCorrectionLevel.L, 1));
        assertThrows(InvalidGroupException.class, () -> bit.getCodewordsPerBlockInGroup(1, ErrorCorrectionLevel.L, 0));
        assertThrows(InvalidGroupException.class, () -> bit.getCodewordsPerBlockInGroup(1, ErrorCorrectionLevel.L, 3));
    }

    @Test
    public void testBlockInformationTableGetTotalCodewords() throws Exception {
        BlockInformationTable bit = new BlockInformationTable();
        assertEquals(bit.getTotalCodewords(1, ErrorCorrectionLevel.L), 19);
        assertEquals(bit.getTotalCodewords(1, ErrorCorrectionLevel.H), 9);
        assertEquals(bit.getTotalCodewords(25, ErrorCorrectionLevel.L), 1276);
        assertEquals(bit.getTotalCodewords(40, ErrorCorrectionLevel.L), 2956);
        assertEquals(bit.getTotalCodewords(40, ErrorCorrectionLevel.H), 1276);
    }
}
