package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Encoders.ByteEncoder;

public class ByteEncoderTest {
    
    @Test
    public void testByteEncoder() {
        assertEquals(ByteEncoder.encode("H"), "01001000");
        assertEquals(ByteEncoder.encode("Hello"), "01001000"+"01100101"+"01101100"+"01101100"+"01101111");
        assertEquals(ByteEncoder.encode(", !"), "00101100"+"00100000"+"00100001");
        assertEquals(ByteEncoder.encode("'()*+"), "00100111"+"00101000"+"00101001"+"00101010"+"00101011");
        assertEquals(ByteEncoder.encode("xyz{|}"), "01111000"+"01111001"+"01111010"+"01111011"+"01111100"+"01111101");
    }
}