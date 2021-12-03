package day04;

import java.util.List;

public class FileReader {

    private Common common = new Common();

    public int findSmallestTemperatureSpread(String fileName) {
        int[] characterPositionsToParse = {6, 8, 12, 14};
        return Integer.parseInt(common.getLineWithSmallestDifference(fileName, characterPositionsToParse,1, 2, 33).substring(2, 4));
    }
}