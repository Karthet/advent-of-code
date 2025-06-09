package de.raphael.advent.years.y_2015.day6.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class Part2Test extends BaseTest {

    /**
     * <p><u>Testcase 1:</u></p>
     * turn on 0,0 through 0,0 would increase the total brightness by 1.
     * <p><u>Testcase 2:</u></p>
     * toggle 0,0 through 999,999 would increase the total brightness by 2000000.
     */
    @ParameterizedTest
    @CsvSource({"TestCase4.txt,1", "TestCase5.txt,2000000"})
    void test_run(String filename, int expected) {
        underTest = new Part2();
        testAdvent(filename, expected);
    }

}