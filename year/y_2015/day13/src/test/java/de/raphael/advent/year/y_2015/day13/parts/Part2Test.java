package de.raphael.advent.year.y_2015.day13.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Part2Test extends BaseTest {

    @ParameterizedTest
    @CsvSource({"TestCase1.txt,330"})
    void test_run(String filename, int expected) {

        underTest = new Part2();
        testAdvent(filename, expected);

    }
}