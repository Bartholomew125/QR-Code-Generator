import Encoders.AutoEncoder;
import Encoders.EncodingModeAnalyser;
import Tables.CharacterCapacityTable;
import Types.EncodingMode;
import Types.ErrorCorrectionLevel;
import Util.Utility;

/**
 * QRCodeGenerator is a class that is responsible for generating QR codes.
 */
public class QRCodeGenerator {

    /**
     * Generates a new QR code given the data, with error correction level low, and a fitting version and encoding mode.
     */
    public static QRCode generate(String data) throws Exception {
        return QRCodeGenerator.generate(data, ErrorCorrectionLevel.L);
    }

    /**
     * Generates a new QR code given the data and error correction level, and uses a fitting version and encoding mode.
     */
    public static QRCode generate(String data, ErrorCorrectionLevel errorCorrectionLevel) throws Exception {
        int dataSize = data.length();
        EncodingMode encodingMode = EncodingModeAnalyser.analyse(data);
        int version = new CharacterCapacityTable().get(errorCorrectionLevel, encodingMode, dataSize);
        return QRCodeGenerator.generate(data, errorCorrectionLevel, encodingMode, version);
    }

    /**
     * Generates a new QR code given the data, error correction level, encoding mode and version.
     */
    public static QRCode generate(String data, ErrorCorrectionLevel errorCorrectionLevel, EncodingMode encodingMode, int version) throws Exception {
        String modeIndicator = Utility.generateModeIndicator(encodingMode);
        String characterCountIndicator = Utility.generateCharacterCountIndicator(data, version, encodingMode);
        String encodedData = AutoEncoder.encode(data);
        String bits = modeIndicator + characterCountIndicator + encodedData;
        bits = Utility.addTerminatorZeros(bits, version, errorCorrectionLevel);

        return null;
    }
}
