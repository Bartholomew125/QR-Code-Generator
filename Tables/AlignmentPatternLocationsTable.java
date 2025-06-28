package Tables;
import java.util.ArrayList;

import Exceptions.InvalidVersionException;
import Exceptions.InvalidVersionForAlignmentPatternException;

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
        this.table = new ArrayList<>();
        int[][] locations = {
            {6,18},{6,22},{6,26},{6,30},{6,34},{6,22,38},{6,24,42},{6,26,46},
            {6,28,50},{6,30,54},{6,32,58},{6,34,62},{6,26,46,66},{6,26,48,70},
            {6,26,50,74},{6,30,54,78},{6,30,56,82},{6,30,58,86},{6,34,62,90},
            {6,28,50,72,94},{6,26,50,74,98},{6,30,54,78,102},{6,28,54,80,106},
            {6,32,58,84,110},{6,30,58,86,114},{6,34,62,90,118},{6,26,50,74,98,122},
            {6,30,54,78,102,126},{6,26,52,78,104,130},{6,30,56,82,108,134},
            {6,34,60,86,112,138},{6,30,58,86,114,142},{6,34,62,90,118,146},
            {6,30,54,78,102,126,150},{6,24,50,76,102,128,154},{6,28,54,80,106,132,158},
            {6,32,58,84,110,136,162},{6,26,55,82,110,138,166},{6,30,58,86,114,142,170}
        };
        for (int[] arr : locations) {
            this.table.add(arr);
        }
    }
    
    /**
     * Returns the alignment patterns locations as an array for a given QR code
     * version. There exists no alignment patterns for version 1.
     */
    public int[] get(int qrVersion) throws Exception {
        if (qrVersion == 1) {
            throw new InvalidVersionForAlignmentPatternException(qrVersion);
        }
        if (qrVersion < 1 || qrVersion > 40) {
            throw new InvalidVersionException();
        }
        return this.table.get(qrVersion-2);
    }

}
