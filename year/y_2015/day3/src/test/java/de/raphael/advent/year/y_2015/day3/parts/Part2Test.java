package de.raphael.advent.year.y_2015.day3.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class Part2Test extends BaseTest {

    /**
     * <p><u>Testcase 1:</u></p>
     * ^v delivers presents to 3 houses, because Santa goes north, and then Robo-Santa goes south.
     * <p><u>Testcase 2:</u></p>
     * ^>v< now delivers presents to 3 houses, and Santa and Robo-Santa end up back where they started.
     * <p><u>Testcase 3:</u></p>
     * ^v^v^v^v^v now delivers presents to 11 houses, with Santa going one direction and Robo-Santa going the other.
     */
    @ParameterizedTest
    @CsvSource({"TestCase4.txt,3", "TestCase2.txt,3", "TestCase3.txt,11"})
    void test_run(String filename, int expected) {
        underTest = new Part2();
        testAdvent(filename, expected);
    }

}