package day04.composition;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    private Table table;
    private Skip skip;
    private Parse parse;
    private List<String> filteredTable;

    public Filter(Table table, Skip skip, Parse parse) {
        this.table = table;
        this.skip = skip;
        this.parse = parse;
        setFilteredTable();
    }

    public List<String> getFilteredTable() {
        return filteredTable;
    }

    public List<Integer> getSeparatorLines() {
        List<Integer> separatorLines = new ArrayList<>();
        if (skip.getSeparator() != null) {
            for (int i = 0; i < table.getTable().size(); i++) {
                if (table.getTable().get(i).matches("\s*" + skip.getSeparator() + "*\s*")) {
                    separatorLines.add(i);
                }
            }
        }
        return separatorLines;
    }

    public List<Integer> getLastLinesToSkip() {
        List<Integer> lastLinesToSkip = new ArrayList<>();
        for (int i = skip.getLastNatural(); i > 0; i--) {
            lastLinesToSkip.add(table.getTable().size() - i);
        }
        return lastLinesToSkip;
    }

    public List<Integer> getLineNumbersToSkip() {
        List<Integer> linesNumbersToSkip = new ArrayList<>();
        linesNumbersToSkip.addAll(skip.getFirst());
        linesNumbersToSkip.addAll(getLastLinesToSkip());
        linesNumbersToSkip.addAll(skip.getIntermediate());
        linesNumbersToSkip.addAll(getSeparatorLines());
        return linesNumbersToSkip;
    }

    public List<String> getLinesToSkip() {
        List<String> linesToSkip = new ArrayList<>();
        for (int lineNumber: getLineNumbersToSkip()) {
            linesToSkip.add(table.getTable().get(lineNumber));
        }
        return linesToSkip;
    }

    private void setFilteredTable() {
        filteredTable = new ArrayList(table.getTable());
        filteredTable.removeAll(getLinesToSkip());
    }

    public String getMinDifferenceLine() {
        int min = Integer.MAX_VALUE;
        int lineNumber = 0;
        for (int i = 0; i < filteredTable.size(); i++) {
            int actual = parse.getDifference(filteredTable.get(i));
            if (actual < min) {
                min = actual;
                lineNumber = i;
            }
        }
        return filteredTable.get(lineNumber);
    }

    public int getIndexOfMinDiff() {
        return parse.getNumber(getMinDifferenceLine());
    }

    public String getNameOfMinDiff() {
        return parse.getName(getMinDifferenceLine());
    }

    public Skip getSkip() {
        return skip;
    }

    public Parse getParse() {
        return parse;
    }
}