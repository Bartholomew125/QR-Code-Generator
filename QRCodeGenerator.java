import org.junit.jupiter.api.MethodOrderer.Alphanumeric;

import Encoders.EncodingModeAnalyser;
import Exceptions.InvalidVersionException;
import Tables.CharacterCapacityTable;
import Types.EncodingMode;
import Types.ErrorCorrectionLevel;
import Util.BitPadder;
import Util.Converter;

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
        String modeIndicator = QRCodeGenerator.getModeIndicator(encodingMode);
        String characterCountIndicator = QRCodeGenerator.getCharacterCountIndicator(data, version, encodingMode);
    }

    private static String getModeIndicator(EncodingMode encodingMode) {
        switch (encodingMode) {
            case Numeric:
                return "0001";
            case Alphanumeric:
                return "0010";
            case Byte:
                return "0100";
            case Kanji:
                return "1000";
            default:
                return "0111";
        }
    }

    private static String getCharacterCountIndicator(String data, int version, EncodingMode encodingMode) throws Exception {
        if (version < 1 || version > 40) {
            throw new InvalidVersionException();
        }
        String bits = Converter.decimalToBinary(data.length());
        int desiredLength = -1;
        if (version >= 1 && version <= 9) {
            switch (encodingMode) {
                case Numeric:
                    desiredLength = 10;
                case Alphanumeric:
                    desiredLength = 9;
                case Byte:
                    desiredLength = 8;
                case Kanji:
                    desiredLength = 8;
            }
        }
        else if (version >= 10 && version <= 26) {
            switch (encodingMode) {
                case Numeric:
                    desiredLength = 12;
                case Alphanumeric:
                    desiredLength = 11;
                case Byte:
                    desiredLength = 16;
                case Kanji:
                    desiredLength = 10;
            }
        }
        else {
            switch (encodingMode) {
                case Numeric:
                    desiredLength = 14;
                case Alphanumeric:
                    desiredLength = 13;
                case Byte:
                    desiredLength = 16;
                case Kanji:
                    desiredLength = 12;
            }
        }
        return BitPadder.leftPadZero(bits, desiredLength);
    }
    
}
