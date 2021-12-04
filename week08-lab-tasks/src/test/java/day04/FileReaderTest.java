package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    FileReader fileReader = new FileReader();
    String fileName = "weather.dat";

    @Test
    void findSmallestTemperatureSpread() {
        System.out.println(fileReader.findSmallestTemperatureSpread(fileName));
        assertEquals(14, fileReader.findSmallestTemperatureSpread(fileName));
    }
}