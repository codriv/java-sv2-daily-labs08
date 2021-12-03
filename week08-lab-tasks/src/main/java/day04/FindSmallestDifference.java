package day04;

import java.util.List;

public class FindSmallestDifference {

    Common common = new Common();

    public String findSmallestDifference(String fileName) {
        int[] characterPositionsToParse = {43, 45, 50, 52};
        int[] linesToSkip = {1, 19};
        return common.getLineWithSmallestDifference(fileName, characterPositionsToParse, linesToSkip).substring(7,23).trim();
    }
}