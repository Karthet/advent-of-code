package de.raphael.advent.years.y_2015.day3.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class Part1Test extends BaseTest {

    /**
     * <p><u>Testcase 1:</u></p>
     * > delivers presents to 2 houses: one at the starting location, and one to the east.
     * <p><u>Testcase 2:</u></p>
     * ^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
     * <p><u>Testcase 3:</u></p>
     * ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.
     */
    @ParameterizedTest
    @CsvSource({"TestCase1.txt,2", "TestCase2.txt,4", "TestCase3.txt,2"})
    void test_run(String filename, int expected) {
        underTest = new Part1();
        testAdvent(filename, expected);
    }

}