package de.raphael.advent.years.y_2015.day2.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class Part2Test extends BaseTest {

    /**
     * <p><u>Testcase 1:</u></p>
     * A present with dimensions 2x3x4 requires 2+2+3+3 = 10 feet of ribbon to wrap the present plus 2*3*4 = 24 feet of
     * ribbon for the bow, for a total of 34 feet.
     * <p><u>Testcase 2:</u></p>
     * A present with dimensions 1x1x10 requires 1+1+1+1 = 4 feet of ribbon to wrap the present plus 1*1*10 = 10 feet of
     * ribbon for the bow, for a total of 14 feet.
     *
     */
    @ParameterizedTest
    @CsvSource({"TestCase1.txt,34", "TestCase2.txt,14"})
    void test_run(String filename, int expected) {
        underTest = new Part2();
        testAdvent(filename, expected);
    }

}