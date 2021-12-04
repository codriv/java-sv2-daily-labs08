package day04.withcomposition;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Table {

    private String pathDir = "src/main/resources/datamunging/";
    private Path path;
    private List<String> table;

    public Table(String fileName) {
        path = Path.of(pathDir + fileName);
        setTable();
    }

    public List<String> getTable() {
        return table;
    }

    private void setTable() {
        try {
            table = Files.readAllLines(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}