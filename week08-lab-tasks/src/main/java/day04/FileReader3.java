package day04;

import java.util.List;

public class FileReader3 {

    private List<String> weatherStat;
    private Common3 common = new Common3();

    public int findSmallestTemperatureSpread(String name) {
        weatherStat = common.getTable(name);
        int smallest = Integer.MAX_VALUE;
        int smallestIndex = 2;
        for (int i = 2; i < weatherStat.size() - 1; i++) {
            int max = common.parse(i, 6, 8);
            int min = common.parse(i, 12, 14);
            int spread = max - min;
            if (spread < smallest) {
                smallest = spread;
                smallestIndex = i;
            }
        }
        return common.parse(smallestIndex, 2, 4);
    }
}