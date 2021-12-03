package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Common {

    private String pathDir = "src/main/resources/datamunging/";
    private Path path;

    public List<String> getTable(String name) {
        List<String> table = null;
        path = Path.of(pathDir + name);
        try {
            table = Files.readAllLines(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return table;
    }

    public List<String> getFilteredTable(List<String> table, int[] lines){
        List<String> filteredTable = new ArrayList<>(List.copyOf(table));
        List<String> linesToDelete = new ArrayList<>();
        for (int line: lines) {
            linesToDelete.add(table.get(line - 1));
        }
        filteredTable.removeAll(linesToDelete);
        return filteredTable;
    }

    public String getLineWithSmallestDifference(String name, int[] parse, int[] linesToSkip) {
        List<String> table = getFilteredTable(getTable(name), linesToSkip);
        int smallest = Integer.MAX_VALUE;
        int smallestIndex = 0;
        for (int i = 0; i < table.size(); i++) {
            int max = parse(table, i, parse[0], parse[1]);
            int min = parse(table, i, parse[2], parse[3]);
            int spread = Math.abs(max - min);
            if (spread < smallest) {
                smallest = spread;
                smallestIndex = i;
            }
        }
        return table.get(smallestIndex);
    }

    private int parse(List<String> table, int i, int from, int to) {
        return Integer.parseInt(table.get(i).substring(from, to));
    }
}