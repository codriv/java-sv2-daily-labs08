package day01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberSequenceTest {
    List<Integer> numbers = Arrays.asList(2,5,8,15,23,95);

    @Test
    void testNumberSequence() {
        NumberSequence numberSequence = new NumberSequence(numbers);
        assertEquals(8, numberSequence.getNumbers().get(2));
    }

    @Test
    void testNumberSequenceRandom() {
        NumberSequence numberSequence = new NumberSequence(4, 2, 8);
        System.out.println(numberSequence.getNumbers());
        assertEquals(4, numberSequence.getNumbers().size());
    }

    @Test
    void testNumberSequenceAverage() {
        NumberSequence numberSequence = new NumberSequence(numbers);
        List<Integer> closeToAverage = numberSequence.closeToAverage(10);
        assertEquals(2, closeToAverage.size());
        System.out.println(closeToAverage);
    }
}