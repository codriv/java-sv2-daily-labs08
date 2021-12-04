package day04.composition;

public class Parse {

    private Position number;
    private Position name;
    private Position min;
    private Position max;

    public Parse(Position min, Position max) {
        this.min = min;
        this.max = max;
    }

    public Parse(Position number, Position min, Position max) {
        this(min, max);
        this.number = number;
    }

    public Parse(Position number, Position name, Position min, Position max) {
        this(number, min, max);
        this.name = name;
    }

    private int getInt(String line, Position position) {
        return Integer.parseInt(getSubString(line, position).trim());
    }

    public String getSubString(String line, Position position) {
        return line.substring(position.getStart(), position.getEnd());
    }

    public int getNumber(String line) {
        return getInt(line, number);
    }

    public String getName(String line) {
        return getSubString(line, name);
    }

    public int getMin(String line) {
        return getInt(line, min);
    }

    public int getMax(String line) {
        return getInt(line, max);
    }

    public int getDifference(String line) {
        return Math.abs(getMax(line) - getMin(line));
    }
}