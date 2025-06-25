import java.util.HashMap;

/**
 * AlphanumericTable is a class that holds the alphanumeric characters, and the
 * integer values associated with them.
 */
public class AlphanumericTable {

    private HashMap<String,Integer> table;

    public AlphanumericTable() {
        this.table = new HashMap<>();
        String[] characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".split("");
        for (int i = 0; i < characters.length; i++) {
            this.table.put(characters[i], i);
        }
    }
    
    /**
     * Returns the integer associated with the given character.
     */
    public int get(String character) throws Exception{
        if (!this.table.containsKey(character)) {
            throw new Exception("The character "+character+" is not alphanumeric.");
        }
        return this.table.get(character);
    }
}
