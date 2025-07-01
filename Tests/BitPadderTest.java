package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Util.BitPadder;

public class BitPadderTest {

    @Test
    public void testBitPadder() {
        assertEquals(BitPadder.leftPadZero("", 2), "00");
        assertEquals(BitPadder.leftPadZero("1", 2), "01");
        assertEquals(BitPadder.leftPadZero("00", 2), "00");
        assertEquals(BitPadder.leftPadZero("10", 5), "00010");
        assertEquals(BitPadder.leftPadZero("1000", 0), "1000");
    }
    
}
