package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Encoders.EncodingModeAnalyser;
import Types.EncodingMode;

public class EncodingModeAnalyserTest {

    @Test
    public void testEncodingModeAnalyser() {
        assertEquals(EncodingModeAnalyser.analyse("0123456789"), EncodingMode.Numeric);
        assertEquals(EncodingModeAnalyser.analyse("01234A6789"), EncodingMode.Alphanumeric);
        assertEquals(EncodingModeAnalyser.analyse("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), EncodingMode.Alphanumeric);
        assertEquals(EncodingModeAnalyser.analyse("ABCDEFGHIJKlMNOPQRSTUVWXYZ"), EncodingMode.Byte);
        assertEquals(EncodingModeAnalyser.analyse("abcdefh ij ./æøå"), EncodingMode.Byte);
        assertEquals(EncodingModeAnalyser.analyse("abcdefh 我j ./"), EncodingMode.Kanji);
    }
}
