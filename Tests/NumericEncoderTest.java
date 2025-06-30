package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Encoders.NumericEncoder;

public class NumericEncoderTest {
    
    @Test
    public void testNumericEncoder() throws Exception {
        assertEquals(NumericEncoder.encode("8675309"), "110110001110000100101001");
        assertEquals(NumericEncoder.encode("001001"), "00010001");
        assertEquals(NumericEncoder.encode("1111"), "00011011110001");
        assertEquals(NumericEncoder.encode("128001128"), "001000000000010010000000");
        assertEquals(NumericEncoder.encode("9909"), "01111011110");
    }
}
