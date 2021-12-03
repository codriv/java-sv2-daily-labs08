package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FindSmallestDifference2 {

    //  private String pathDir;
    private String pathDir = ("src/main/resources/datamunging/");
    private List<String> table;

//  public FindSmallestDifference(String pathDir) {
//      this.pathDir = pathDir;
//  }

    public String findSmallestDifference(String fileName) {
        table = getTable(Path.of(pathDir + fileName));
        int smallest = Integer.MAX_VALUE;
        int smallestIndex = 1;
        for (int i = 1; i < table.size(); i++) {
//          if (i == 18) {continue;}
            if ((table.get(i)).matches(".*----------.*")) {continue;}
            int max = parse(i, 43, 45);
            int min = parse(i, 50, 52);
            int spread = Math.abs(max - min);
            if (spread < smallest) {
                smallest = spread;
                smallestIndex = i;
            }
        }
        return table.get(smallestIndex).substring(7,23).trim();
    }

    private int parse(int i, int from, int to) {
        return Integer.parseInt(table.get(i).substring(from, to));
    }

    private List<String> getTable(Path path) {
        try {
            table = Files.readAllLines(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return table;
    }
}