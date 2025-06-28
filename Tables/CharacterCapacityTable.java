package Tables;
import java.util.Arrays;

import Exceptions.InvalidEncodingModeException;
import Exceptions.InvalidVersionException;
import Types.EncodingMode;
import Types.ErrorCorrectionLevel;

/**
 * CharacterCapacitiyTable is a class that is repsonsible for holding
 * information about how many characters each QR code version can hold, hiven
 * the encoding mode.
 * 
 * @see <a href=
 *      "https://www.thonky.com/qr-code-tutorial/character-capacities">Thonky's
 *      QR Code Tutorial</a>
 */
public class CharacterCapacityTable {

    private int[] numericTable;
    private int[] alphanumericTable;
    private int[] byteTable;
    private int[] kanjiTable;

    public CharacterCapacityTable() {
        this.numericTable = new int[]{41,34,27,17,77,63,48,34,127,101,77,58,187,
            149,111,82,255,202,144,106,322,255,178,139,370,293,207,154,461,365,
            259,202,552,432,312,235,652,513,364,288,772,604,427,331,883,691,489,
            374,1022,796,580,427,1101,871,621,468,1250,991,703,530,1408,1082,
            775,602,1548,1212,876,674,1725,1346,948,746,1903,1500,1063,813,2061,
            1600,1159,919,2232,1708,1224,969,2409,1872,1358,1056,2620,2059,1468,
            1108,2812,2188,1588,1228,3057,2395,1718,1286,3283,2544,1804,1425,
            3517,2701,1933,1501,3669,2857,2085,1581,3909,3035,2181,1677,4158,
            3289,2358,1782,4417,3486,2473,1897,4686,3693,2670,2022,4965,3909,
            2805,2157,5253,4134,2949,2301,5529,4343,3081,2361,5836,4588,3244,
            2524,6153,4775,3417,2625,6479,5039,3599,2735,6743,5313,3791,2927,
            7089,5596,3993,3057};
        this.alphanumericTable = new int[]{25,20,16,10,47,38,29,20,77,61,47,35,
            114,90,67,50,154,122,87,64,195,154,108,84,224,178,125,93,279,221,
            157,122,335,262,189,143,395,311,221,174,468,366,259,200,535,419,296,
            227,619,483,352,259,667,528,376,283,758,600,426,321,854,656,470,365,
            938,734,531,408,1046,816,574,452,1153,909,644,493,1249,970,702,557,
            1352,1035,742,587,1460,1134,823,640,1588,1248,890,672,1704,1326,963,
            744,1853,1451,1041,779,1990,1542,1094,864,2132,1637,1172,910,2223,
            1732,1263,958,2369,1839,1322,1016,2520,1994,1429,1080,2677,2113,
            1499,1150,2840,2238,1618,1226,3009,2369,1700,1307,3183,2506,1787,
            1394,3351,2632,1867,1431,3537,2780,1966,1530,3729,2894,2071,1591,
            3927,3054,2181,1658,4087,3220,2298,1774,4296,3391,2420,1852};
        this.byteTable = new int[]{17,14,11,7,32,26,20,14,53,42,32,24,78,62,46,
            34,106,84,60,44,134,106,74,58,154,122,86,64,192,152,108,84,230,180,
            130,98,271,213,151,119,321,251,177,137,367,287,203,155,425,331,241,
            177,458,362,258,194,520,412,292,220,586,450,322,250,644,504,364,280,
            718,560,394,310,792,624,442,338,858,666,482,382,929,711,509,403,
            1003,779,565,439,1091,857,611,461,1171,911,661,511,1273,997,715,535,
            1367,1059,751,593,1465,1125,805,625,1528,1190,868,658,1628,1264,908,
            698,1732,1370,982,742,1840,1452,1030,790,1952,1538,1112,842,2068,
            1628,1168,898,2188,1722,1228,958,2303,1809,1283,983,2431,1911,1351,
            1051,2563,1989,1423,1093,2699,2099,1499,1139,2809,2213,1579,1219,
            2953,2331,1663,1273};
        this.kanjiTable = new int[]{10,8,7,4,20,16,12,8,32,26,20,15,48,38,28,21,
            65,52,37,27,82,65,45,36,95,75,53,39,118,93,66,52,141,111,80,60,167,
            131,93,74,198,155,109,85,226,177,125,96,262,204,149,109,282,223,159,
            120,320,254,180,136,361,277,198,154,397,310,224,173,442,345,243,191,
            488,384,272,208,528,410,297,235,572,438,314,248,618,480,348,270,672,
            528,376,284,721,561,407,315,784,614,440,330,842,652,462,365,902,692,
            496,385,940,732,534,405,1002,778,559,430,1066,843,604,457,1132,894,
            634,486,1201,947,684,518,1273,1002,719,553,1347,1060,756,590,1417,
            1113,790,605,1496,1176,832,647,1577,1224,876,673,1661,1292,923,701,
            1729,1362,972,750,1817,1435,1024,784};
    }

    private int[] getTableFromEncodingMode(EncodingMode encodingMode) {
        switch (encodingMode) {
            case Numeric:
                return this.numericTable;
            case Alphanumeric:
                return this.alphanumericTable;
            case Byte:
                return this.byteTable;
            case Kanji:
                return this.kanjiTable;
            default:
                return null; 
        }
    }

    /**
     * Returns the number of available characters given the version, error
     * correction level and encoding mode.
     */
    public int get(int version, ErrorCorrectionLevel errorCorrectionLevel, EncodingMode encodingMode) throws Exception {
        if (version < 1 || version > 40) {
            throw new InvalidVersionException();
        }
        int index = (version-1)*4 +
        Arrays.asList(ErrorCorrectionLevel.values()).indexOf(errorCorrectionLevel);
        return this.getTableFromEncodingMode(encodingMode)[index];
    }

    /**
     * Returns the smallest version required to hold a specified capacity given
     * the error correction level and encoding mode. Returns -1 if there are no
     * versions large enough to contain it.
     */
    public int get(ErrorCorrectionLevel errorCorrectionLevel, EncodingMode encodingMode, int capacity) {
        int[] table = this.getTableFromEncodingMode(encodingMode);
        int offset = Arrays.asList(ErrorCorrectionLevel.values()).indexOf(errorCorrectionLevel);
        for (int i = offset; i < 40*4; i = i + 4) {
            if (table[i] >= capacity) {
                return i/4 + 1;
            }
        }
        return -1;
    }
}

