package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindSmallestDifferenceTest {

    FindSmallestDifference findSmallestDifference = new FindSmallestDifference();
    String fileName = "football.dat";

    @Test
    void findSmallestDifference() {
        System.out.println(findSmallestDifference.findSmallestDifference(fileName));
        assertEquals("Aston_Villa", findSmallestDifference.findSmallestDifference(fileName));
    }

}