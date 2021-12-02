package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

    private Path path = Path.of("src/test/resources/weather.dat");
    private List<String> weatherStat;

    public int findSmallestTemperatureSpread(Path path) {
        List<String> weatherStat = getWeatherStat(path);
        List<String> workList = weatherStat.subList(2, weatherStat.size());
        int smallest = Integer.MAX_VALUE;
        int smallestIndex = 0;
        for (int i = 2; i < weatherStat.size() - 1; i++) {
            int max = Integer.parseInt(weatherStat.get(i).substring(6,8));
            int min = Integer.parseInt(weatherStat.get(i).substring(12,14));
            int spread = max - min;
            if (spread < smallest) {
                smallest = spread;
                smallestIndex = i;
            }
        }
        return Integer.parseInt(weatherStat.get(smallestIndex).substring(2,4));
    }

    public List<String> getWeatherStat(Path path) {
        try {
            weatherStat = Files.readAllLines(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return weatherStat;
    }
}