import java.util.ArrayList;

import exceptions.InvalidVersionException;
import exceptions.InvalidVersionForAlignmentPatternException;

/**
 * AlignmentPatternLocationsTable is a class that holds the table for the
 * alignment patterns locations.
 * 
 * @see <a href=
 *      "https://www.thonky.com/qr-code-tutorial/alignment-pattern-locations">Thonky's
 *      QR Code Tutorial</a>
 */
public class AlignmentPatternLocationsTable {
    
    private ArrayList<int[]> table;

    public AlignmentPatternLocationsTable() {
        this.table.add(new int[]{6,18});
        this.table.add(new int[]{6,22});
        this.table.add(new int[]{6,26});
        this.table.add(new int[]{6,30});
        this.table.add(new int[]{6,34});
        this.table.add(new int[]{6,22,38});
        this.table.add(new int[]{6,24,42});
        this.table.add(new int[]{6,26,46});
        this.table.add(new int[]{6,28,50});
        this.table.add(new int[]{6,30,54});
        this.table.add(new int[]{6,32,58});
        this.table.add(new int[]{6,34,62});
        this.table.add(new int[]{6,26,46,66});
        this.table.add(new int[]{6,26,48,70});
        this.table.add(new int[]{6,26,50,74});
        this.table.add(new int[]{6,30,54,78});
        this.table.add(new int[]{6,30,56,82});
        this.table.add(new int[]{6,30,58,86});
        this.table.add(new int[]{6,34,62,90});
        this.table.add(new int[]{6,28,50,72,94});
        this.table.add(new int[]{6,26,50,74,98});
        this.table.add(new int[]{6,30,54,78,102});
        this.table.add(new int[]{6,28,54,80,106});
        this.table.add(new int[]{6,32,58,84,110});
        this.table.add(new int[]{6,30,58,86,114});
        this.table.add(new int[]{6,34,62,90,118});
        this.table.add(new int[]{6,26,50,74,98,122});
        this.table.add(new int[]{6,30,54,78,102,126});
        this.table.add(new int[]{6,26,52,78,104,130});
        this.table.add(new int[]{6,30,56,82,108,134});
        this.table.add(new int[]{6,34,60,86,112,138});
        this.table.add(new int[]{6,30,58,86,114,142});
        this.table.add(new int[]{6,34,62,90,118,146});
        this.table.add(new int[]{6,30,54,78,102,126,150});
        this.table.add(new int[]{6,24,50,76,102,128,154});
        this.table.add(new int[]{6,28,54,80,106,132,158});
        this.table.add(new int[]{6,32,58,84,110,136,162});
        this.table.add(new int[]{6,26,55,82,110,138,166});
        this.table.add(new int[]{6,30,58,86,114,142,170});
    }
    
    /**
     * Returns the alignment patterns locations as an array for a given QR code
     * version. There exists no alignment patterns for version 1.
     */
    public int[] get(int qrVersion) throws Exception {
        if (qrVersion == 2) {
            throw new InvalidVersionForAlignmentPatternException(qrVersion);
        }
        if (qrVersion < 1 || qrVersion > 40) {
            throw new InvalidVersionException();
        }
        return this.table.get(qrVersion-2);
    }

}
