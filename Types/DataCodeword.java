package Types;

import Exceptions.InvalidDataCodewordContentException;
import Exceptions.InvalidDataCodewordLengthException;

/**
 * The class DataCodeword is used to store a String of 8 bits (a byte).
 */
public class DataCodeword {
    
    private String dataCodeword;

    public DataCodeword(String dataCodeword) throws Exception {
        this.set(dataCodeword);
    }

    /**
     * Checks the validity of the given data codeword. If it is not a length of
     * 8, og has other characters than 1 or 0, an appropriate Exception will be
     * thrown
     */
    private void checkValidity(String dataCodeword) throws Exception {
        if (dataCodeword.length() != 8) {
            throw new InvalidDataCodewordLengthException();
        }
        else if (dataCodeword.replace("0", "").replace("1", "").length() != 0) {
            throw new InvalidDataCodewordContentException();
        }
    }

    public String get() {
        return this.dataCodeword;
    }

    /**
     * Sets the current data codeword, and throws appropriate exceptions, if it
     * is not valid.
     */
    public void set(String dataCodeword) throws Exception {
        this.checkValidity(dataCodeword);
        this.dataCodeword = dataCodeword;
    }

}
