package de.raphael.advent.year.y_2015.day2.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class Part1Test extends BaseTest {

    /**
     * <p><u>Testcase 1:</u></p>
     * A present with dimensions 2x3x4 requires 2*6 + 2*12 + 2*8 = 52 square feet of wrapping paper plus 6 square feet
     * of slack, for a total of 58 square feet.
     * <p><u>Testcase 2:</u></p>
     * A present with dimensions 1x1x10 requires 2*1 + 2*10 + 2*10 = 42 square feet of wrapping paper plus 1 square
     * foot of slack, for a total of 43 square feet.
     *
     */
    @ParameterizedTest
    @CsvSource({"TestCase1.txt,58", "TestCase2.txt,43"})
    void test_run(String filename, int expected) {
        underTest = new Part1();
        testAdvent(filename, expected);
    }

}