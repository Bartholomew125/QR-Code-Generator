package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Util.Converter;

public class ConverterTest {
    
    @Test
    public void testConverterDecimalToBinary() {
        assertEquals(Converter.decimalToBinary(2), "10");
        assertEquals(Converter.decimalToBinary(16), "10000");
        assertEquals(Converter.decimalToBinary(127), "1111111");
        assertEquals(Converter.decimalToBinary(73829), "10010000001100101");
        assertEquals(Converter.decimalToBinary(0), "0");
    }
}
