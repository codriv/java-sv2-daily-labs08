package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Common {

    private List<String> table;
    private String pathDir = "src/main/resources/datamunging/";
    private Path path;

    public int parse(int i, int from, int to) {
        return Integer.parseInt(table.get(i).substring(from, to));
    }

    public List<String> getTable(String name) {
        path = Path.of(pathDir + name);
        try {
            table = Files.readAllLines(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return table;
    }
}