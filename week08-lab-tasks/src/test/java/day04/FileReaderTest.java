package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
    FileReader fileReader = new FileReader();
    Path path = Path.of("src/test/resources/weather.dat");

    @Test
    void findSmallestTemperatureSpread() {
        assertEquals(14, fileReader.findSmallestTemperatureSpread(path));
        System.out.println(fileReader.findSmallestTemperatureSpread(path));
    }

}