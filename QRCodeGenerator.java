import Encoders.EncodingModeAnalyser;
import Tables.CharacterCapacityTable;
import Types.EncodingMode;
import Types.ErrorCorrectionLevel;

/**
 * QRCodeGenerator is a class that is responsible for generating QR codes.
 */
public class QRCodeGenerator {

    /**
     * Generates a new QR code given the data, with error correction level low, and a fitting version and encoding mode.
     */
    public static QRCode generate(String data) {
        return QRCodeGenerator.generate(data, ErrorCorrectionLevel.L);
    }

    /**
     * Generates a new QR code given the data and error correction level, and uses a fitting version and encoding mode.
     */
    public static QRCode generate(String data, ErrorCorrectionLevel errorCorrectionLevel) {
        int dataSize = data.length();
        EncodingMode encodingMode = EncodingModeAnalyser.analyse(data);
        int version = new CharacterCapacityTable().get(errorCorrectionLevel, encodingMode, dataSize);
        return QRCodeGenerator.generate(data, errorCorrectionLevel, encodingMode, version);
    }

    /**
     * Generates a new QR code given the data, error correction level, encoding mode and version.
     */
    public static QRCode generate(String data, ErrorCorrectionLevel errorCorrectionLevel, EncodingMode encodingMode, int version) {
        
    }
    
}
