package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Util.BitPadder;

public class BitPadderTest {

    @Test
    public void testBitPadderLeftPadZero() {
        assertEquals(BitPadder.leftPadZero("", 2), "00");
        assertEquals(BitPadder.leftPadZero("1", 2), "01");
        assertEquals(BitPadder.leftPadZero("00", 2), "00");
        assertEquals(BitPadder.leftPadZero("10", 5), "00010");
        assertEquals(BitPadder.leftPadZero("1000", 0), "1000");
    }

    @Test
    public void testBitPadderRightPadZero() {
        assertEquals(BitPadder.rightPadZero("", 2), "00");
        assertEquals(BitPadder.rightPadZero("1", 2), "10");
        assertEquals(BitPadder.rightPadZero("00", 2), "00");
        assertEquals(BitPadder.rightPadZero("10", 5), "10000");
        assertEquals(BitPadder.rightPadZero("1000", 0), "1000");
    }

    @Test
    public void testBitPadderPadBits() {
        assertEquals(BitPadder.padBits("", 4, "10", true), "1010");
        assertEquals(BitPadder.padBits("1", 4, "10", true), "0101");
        assertEquals(BitPadder.padBits("010", 7, "110", false), "0101101");
        assertEquals(BitPadder.padBits("000", 4, "10", true), "0000");
        assertEquals(BitPadder.padBits("110011", 4, "1010", false), "110011");
    }
    
}
