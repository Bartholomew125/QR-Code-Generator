package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Encoders.AutoEncoder;
import Encoders.ByteEncoder;
import Encoders.NumericEncoder;

public class AutoEncoderTest {
    
    @Test
    public void testAutoEncoder() throws Exception {
        assertEquals(AutoEncoder.encode("HELLO WORLD"), "0110000101101111000110100010111001011011100010011010100001101");
        assertEquals(NumericEncoder.encode("128001128"), "001000000000010010000000");
        assertEquals(ByteEncoder.encode("Hello"), "01001000"+"01100101"+"01101100"+"01101100"+"01101111");
    }
}
