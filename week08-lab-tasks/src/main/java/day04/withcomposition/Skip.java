package day04.withcomposition;

import java.util.ArrayList;
import java.util.List;

public class Skip {

    private int firstNatural;
    private int lastNatural;
    private String separator;
    private int[] intermediateNatural;

    public Skip(int firstNatural, int lastNatural, int... intermediateNatural) {
        this.firstNatural = firstNatural;
        this.lastNatural = lastNatural;
        this.intermediateNatural = intermediateNatural;
    }

    public Skip(int firstNatural, int lastNatural, String separator, int... intermediateNatural) {
        this(firstNatural, lastNatural, intermediateNatural);
        this.separator = separator;
    }

    public int getLastNatural() {
        return lastNatural;
    }

    public String getSeparator() {
        return separator;
    }

    public List<Integer> getFirst() {
        List<Integer> first = new ArrayList<>();
        for (int i = 0; i < firstNatural; i++) {
            first.add(i);
        }
        return first;
    }

    public List<Integer> getIntermediate() {
        List<Integer> intermediate = new ArrayList<>();
        for (int i = 0; i < intermediateNatural.length; i++) {
            intermediate.add(intermediateNatural[i] - 1);
        }
        return intermediate;
    }
}