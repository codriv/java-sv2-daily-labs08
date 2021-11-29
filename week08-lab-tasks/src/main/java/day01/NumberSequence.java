package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequence {
    private List<Integer> numbers;

    public NumberSequence(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public NumberSequence(int numOfRandoms, int min, int max) {
        this.numbers = createRandoms(numOfRandoms, min, max);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> createRandoms(int numOfRandoms, int min, int max) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numOfRandoms; i++) {
            numbers.add(random.nextInt(max) + min);
        }
        return numbers;
    }

    public List<Integer> closeToAverage(int value) {
        List<Integer> closeToAverage = new ArrayList<>();
        int average = getAverage();
        for (Integer number: this.numbers) {
            if (Math.abs(number - average) <= value) {
                closeToAverage.add(number);
            }
        }
        return closeToAverage;
    }

    private int getAverage(){
        int average = 0;
        int sum = 0;
        for (int i = 0; i < this.numbers.size(); i++) {
            sum += this.numbers.get(i);
        }
        average = sum / this.numbers.size();
        return average;
    }
}