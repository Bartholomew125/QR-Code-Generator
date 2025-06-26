import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * EncodingModeAnalyser is a class that is used for analysing what type of
 * encoding mode a given string of data is.
 */
public class EncodingModeAnalyser {

    private static final List<String> NUMERIC = Arrays.asList("0123456789".split(""));
    private static final List<String> ALPHANUMERIC = Arrays.asList("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".split(""));
    private static final List<String> BYTE = EncodingModeAnalyser.getByteCharacters();

    /**
     * Returns all the byte characters.
     */
    private static List<String> getByteCharacters() {
        List<String> characters = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            characters.add(String.valueOf((char) i));
        }
        return characters;
    }

    /**
     * Returns the encoding mode that should be used for the given data.
     */
    public static EncodingMode analyse(String data) {
        if (data.chars().allMatch(c -> NUMERIC.contains(c))) {
            return EncodingMode.Numeric;
        }
        if (data.chars().allMatch(c -> ALPHANUMERIC.contains(c))) {
            return EncodingMode.Alphanumeric;
        }
        if (data.chars().allMatch(c -> BYTE.contains(c))) {
            return EncodingMode.Byte;
        }
        return EncodingMode.Kanji;
    }
}
