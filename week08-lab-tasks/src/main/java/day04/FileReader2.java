package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader2 {
    private String pathDir = "src/main/resources/datamunging/";
    //    private String pathDir;
    private List<String> weatherStat;

//    public FileReader(String pathDir) {
//        this.pathDir = pathDir;
//    }

    public int findSmallestTemperatureSpread(String name) {
        Path path = Path.of(pathDir + name);
        weatherStat = getWeatherStat(path);
        int smallest = Integer.MAX_VALUE;
        int smallestIndex = 2;
        for (int i = 2; i < weatherStat.size() - 1; i++) {
            int max = parse(i, 6, 8);
            int min = parse(i, 12, 14);
            int spread = max - min;
            if (spread < smallest) {
                smallest = spread;
                smallestIndex = i;
            }
        }
        return parse(smallestIndex, 2, 4);
    }

    private int parse(int index, int from, int to) {
        return Integer.parseInt(weatherStat.get(index).substring(from, to));
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