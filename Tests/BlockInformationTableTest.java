package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import Exceptions.InvalidGroupException;
import Exceptions.InvalidVersionException;
import Tables.BlockInformationTable;
import Types.ErrorCorrectionLevel;

public class BlockInformationTableTest {
    
    @Test
    public void testBlockInformationTableGetBlocksInGroup() throws Exception {
        BlockInformationTable bit = new BlockInformationTable();
        assertEquals(bit.getBlocksInGroup(1, ErrorCorrectionLevel.M, 1), Integer.valueOf(1));
        assertEquals(bit.getBlocksInGroup(10, ErrorCorrectionLevel.L, 2), Integer.valueOf(2));
        assertEquals(bit.getBlocksInGroup(20, ErrorCorrectionLevel.Q, 1), Integer.valueOf(15));
        assertEquals(bit.getBlocksInGroup(30, ErrorCorrectionLevel.H, 2), Integer.valueOf(25));
        assertEquals(bit.getBlocksInGroup(40, ErrorCorrectionLevel.M, 2), Integer.valueOf(31));
        assertEquals(bit.getBlocksInGroup(1, ErrorCorrectionLevel.L, 2), null);
    }

    @Test
    public void testBlockInformationTableGetCodewordsPerBlockInGroup() throws Exception {
        BlockInformationTable bit = new BlockInformationTable();
        assertEquals(bit.getCodewordsPerBlockInGroup(1, ErrorCorrectionLevel.M, 1), Integer.valueOf(16));
        assertEquals(bit.getCodewordsPerBlockInGroup(10, ErrorCorrectionLevel.L, 2), Integer.valueOf(69));
        assertEquals(bit.getCodewordsPerBlockInGroup(20, ErrorCorrectionLevel.Q, 1), Integer.valueOf(24));
        assertEquals(bit.getCodewordsPerBlockInGroup(30, ErrorCorrectionLevel.H, 2), Integer.valueOf(16));
        assertEquals(bit.getCodewordsPerBlockInGroup(40, ErrorCorrectionLevel.M, 2), Integer.valueOf(48));
        assertEquals(bit.getCodewordsPerBlockInGroup(1, ErrorCorrectionLevel.L, 2), null);
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
}
