package day04;

import java.util.List;

public class FindSmallestDifference3 {

    Common3 common = new Common3();
    private List<String> table;

    public String findSmallestDifference(String fileName) {
        table = common.getTable(fileName);
        int smallest = Integer.MAX_VALUE;
        int smallestIndex = 1;
        for (int i = 1; i < table.size(); i++) {
//          if (i == 18) {continue;}
            if ((table.get(i)).matches(".*----------.*")) {continue;}
            int max = common.parse(i, 43, 45);
            int min = common.parse(i, 50, 52);
            int spread = Math.abs(max - min);
            if (spread < smallest) {
                smallest = spread;
                smallestIndex = i;
            }
        }
        return table.get(smallestIndex).substring(7,23).trim();
    }
}