package day04.composition;

public class Position {

    private int start;
    private int end;

    public Position(int start, int length) {
        this.start = start - 1;
        end = start - 1 + length;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}