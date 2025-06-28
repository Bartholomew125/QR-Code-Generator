package Tables;
import java.util.Arrays;

import Exceptions.InvalidVersionException;
import Types.ErrorCorrectionLevel;

/**
 * BlockInformationTable is a class that is responsible for holding information
 * about the number of blocks in groups, and the number of data codewords in
 * each block.
 * 
 * @see <a href=
 *      "https://www.thonky.com/qr-code-tutorial/error-correction-table">Thonky's
 *      QR Code Tutorial</a>
 */
public class BlockInformationTable {

    private Integer[] blocksInGroup1Table;
    private Integer[] dataCodewordsInGroup1BlocksTable;
    private Integer[] blocksInGroup2Table;
    private Integer[] dataCodewordsInGroup2BlocksTable;

    public BlockInformationTable() {
        this.blocksInGroup1Table = new Integer[]{1,1,1,1,1,1,1,1,1,1,2,2,1,2,2,
            4,1,2,2,2,2,4,4,4,2,4,2,4,2,2,4,4,2,3,4,4,2,4,6,6,4,1,4,3,2,6,4,7,4,
            8,8,12,3,4,11,11,5,5,5,11,5,7,15,3,1,10,1,2,5,9,17,2,3,3,17,9,3,3,
            15,15,4,17,17,19,2,17,7,34,4,4,11,16,6,6,11,30,8,8,7,22,10,19,28,33,
            8,22,8,12,3,3,4,11,7,21,1,19,5,19,15,23,13,2,42,23,17,10,10,19,17,
            14,29,11,13,14,44,59,12,12,39,22,6,6,46,2,17,29,49,24,4,13,48,42,20,
            40,43,10,19,18,34,20};
        this.dataCodewordsInGroup1BlocksTable = new Integer[]{19,16,13,9,34,28,
            22,16,55,44,17,13,80,32,24,9,108,43,15,11,68,27,19,15,78,31,14,13,
            97,38,18,14,116,36,16,12,68,43,19,15,81,50,22,12,92,36,20,14,107,37,
            20,11,115,40,16,12,87,41,24,12,98,45,19,15,107,46,22,14,120,43,22,
            14,113,44,21,13,107,41,24,15,116,42,22,16,111,46,24,13,121,47,24,15,
            117,45,24,16,106,47,24,15,114,46,22,16,122,45,23,15,117,45,24,15,
            116,45,23,15,115,47,24,15,115,46,24,15,115,46,24,15,115,46,24,15,
            115,46,24,16,121,47,24,15,121,47,24,15,122,46,24,15,122,46,24,15,
            117,47,24,15,118,47,24,15};
        this.blocksInGroup2Table = new Integer[]{null,null,null,null,null,null,
            null,null,null,null,null,null,null,null,null,null,null,null,2,2,
            null,null,null,null,null,null,4,1,null,2,2,2,null,2,4,4,2,1,2,2,
            null,4,4,8,2,2,6,4,null,1,4,4,1,5,5,5,1,5,7,7,1,3,2,13,5,1,15,17,1,
            4,1,19,4,11,4,16,5,13,5,10,4,null,6,6,7,null,16,null,5,14,14,14,4,
            14,16,2,4,13,22,13,2,4,6,4,4,3,26,28,10,23,31,31,7,7,37,26,10,10,25,
            25,3,29,1,28,null,23,35,35,1,21,19,46,6,23,7,1,7,26,14,41,14,34,10,
            64,4,14,10,46,18,32,14,32,4,7,22,67,6,31,34,61};
        this.dataCodewordsInGroup2BlocksTable = new Integer[]{null,null,null,
            null,null,null,null,null,null,null,null,null,null,null,null,null,
            null,null,16,12,null,null,null,null,null,null,15,14,null,39,19,15,
            null,37,17,13,69,44,20,16,null,51,23,13,93,37,21,15,null,38,21,12,
            116,41,17,13,88,42,25,13,99,46,20,16,108,47,23,15,121,44,23,15,114,
            45,22,14,108,42,25,16,117,null,23,17,112,null,25,null,122,48,25,16,
            118,46,25,17,107,48,25,16,115,47,23,17,123,46,24,16,118,46,25,16,
            117,46,24,16,116,48,25,16,116,47,25,16,null,47,25,16,116,47,25,16,
            116,47,25,17,122,48,25,16,122,48,25,16,123,47,25,16,123,47,25,16,
            118,48,25,16,119,48,25,16};
    }

    /**
     * Returns the number of blocks given the version, error correction level
     * and a group. The possible groups are 1 and 2.
     */
    public Integer getBlocksInGroup(int version, ErrorCorrectionLevel errorCorrectionLevel, int group) throws Exception {
        if (version < 1 || version > 40) {
            throw new InvalidVersionException();
        }
        int index = (version-1)*4 +
        Arrays.asList(ErrorCorrectionLevel.values()).indexOf(errorCorrectionLevel);
        switch (group) {
            case 1:
                return this.blocksInGroup1Table[index];
            case 2:
                return this.blocksInGroup2Table[index];
            default:
                throw new InvalidGroupException();
        }
    }

    /**
     * Returns the number of codewords in a block given the version, error
     * correction level and a group. The possible groups are 1 and 2.
     */
    public Integer getCodewordsPerBlockInGroup(int version, ErrorCorrectionLevel errorCorrectionLevel, int group) throws Exception {
        if (version < 1 || version > 40) {
            throw new InvalidVersionException();
        }
        int index = (version-1)*4 +
        Arrays.asList(ErrorCorrectionLevel.values()).indexOf(errorCorrectionLevel);
        switch (group) {
            case 1:
                return this.dataCodewordsInGroup1BlocksTable[index];
            case 2:
                return this.dataCodewordsInGroup2BlocksTable[index];
            default:
                throw new InvalidGroupException();
        }

    }

}
