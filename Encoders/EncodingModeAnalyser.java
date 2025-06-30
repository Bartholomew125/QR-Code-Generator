import Types.EncodingMode;

/**
 * EncodingModeAnalyser is a class that is used for analysing what type of
 * encoding mode a given string of data is.
 */
public class EncodingModeAnalyser {

    private static final String NUMERIC = "0123456789";
    private static final String ALPHANUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:";
    private static final String BYTE = EncodingModeAnalyser.getByteCharacters();

    /**
     * Returns all the byte characters.
     */
    private static String getByteCharacters() {
        String characters = "";
        for (int i = 0; i < 256; i++) {
            characters += String.valueOf((char) i);
        }
        return characters;
    }

    /**
     * Checks whether every character in the data string is contained in the
     * checkString.
     */
    private static boolean allIn(String data, String checkString) {
        for (String c : data.split("")) {
            if (!checkString.contains(c)) { return false; }
        }
        return true;
    }

    /**
     * Returns the encoding mode that should be used for the given data.
     */
    public static EncodingMode analyse(String data) {
        if (allIn(data, NUMERIC)) {
            return EncodingMode.Numeric;
        }
        if (allIn(data, ALPHANUMERIC)) {
            return EncodingMode.Alphanumeric;
        }
        if (allIn(data, BYTE)) {
            return EncodingMode.Byte;
        }
        return EncodingMode.Kanji;
    }
}
