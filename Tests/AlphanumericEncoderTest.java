package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Encoders.AlphanumericEncoder;

public class AlphanumericEncoderTest {
    
    @Test
    public void testAlphanumericEncoder() throws Exception {
        assertEquals(AlphanumericEncoder.encode("HE"), "01100001011");
        assertEquals(AlphanumericEncoder.encode("HELLO"), "01100001011"+"01111000110"+"011000");
        assertEquals(AlphanumericEncoder.encode("HELLO WORLD"), "01100001011"+"01111000110"+"10001011100"+"10110111000"+"10011010100"+"001101");
        assertEquals(AlphanumericEncoder.encode("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:"), 
            "00000000001"+
            "00001011101"+
            "00010111001"+
            "00100010101"+
            "00101110001"+
            "00111001101"+
            "01000101001"+
            "01010000101"+
            "01011100001"+
            "01100111101"+
            "01110011001"+
            "01111110101"+
            "10001010001"+
            "10010101101"+
            "10100001001"+
            "10101100101"+
            "10111000001"+
            "11000011101"+
            "11001111001"+
            "11011010101"+
            "11100110001"+
            "11110001101"+
            "101100"
        );
        assertEquals(AlphanumericEncoder.encode(" "), "100100");
    }
}