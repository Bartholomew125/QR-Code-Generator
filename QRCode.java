import Types.EncodingMode;
import Types.ErrorCorrectionLevel;

/**
 * QRCode is a class that represents a QRCode.
 */
public class QRCode {

    private String data;
    private String bits;
    private EncodingMode encodingMode;
    private ErrorCorrectionLevel errorCorrectionLevel;
    private int version;

    public QRCode(String data, String bits, EncodingMode encodingMode, ErrorCorrectionLevel errorCorrectionLevel, int version) {
        this.data = data;
        this.bits = bits;
        this.encodingMode = encodingMode;
        this.errorCorrectionLevel = errorCorrectionLevel;
        this.version = version;
    }
}
