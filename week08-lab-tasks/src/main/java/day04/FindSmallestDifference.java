package day04;

import java.util.List;

public class FindSmallestDifference {

    Common common = new Common();

    public String findSmallestDifference(String fileName) {
        int[] characterPositionsToParse = {43, 45, 50, 52};
        return common.getLineWithSmallestDifference(fileName, characterPositionsToParse, 1, 19).substring(7,23).trim();
    }
}