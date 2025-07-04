package Encoders;

/**
 * AutoEncoder is a class which incodes given data, using the best encoding mode
 * available for that data.
 */
public class AutoEncoder {
    
    /**
     * Incodes the given data with an appropriate encoding mode.
     */
    public static String encode(String data) throws Exception {
        switch (EncodingModeAnalyser.analyse(data)) {
            case Numeric:
                return NumericEncoder.encode(data);
            case Alphanumeric:
                return AlphanumericEncoder.encode(data);
            case Byte:
                return ByteEncoder.encode(data);
            default:
                return null; // Should be kanji encoding.
        }
    }
}
