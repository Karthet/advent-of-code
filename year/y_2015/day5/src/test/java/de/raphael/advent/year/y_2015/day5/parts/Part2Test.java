package de.raphael.advent.year.y_2015.day5.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class Part2Test extends BaseTest {

    /**
     * <p><u>Testcase 1:</u></p>
     * qjhvhtzxzqqjkmpb is nice because is has a pair that appears twice (qj) and a letter that repeats with exactly
     * one letter between them (zxz).
     * <p><u>Testcase 2:</u></p>
     * xxyxx is nice because it has a pair that appears twice and a letter that repeats with one between, even though
     * the letters used by each rule overlap.
     * <p><u>Testcase 3:</u></p>
     * uurcxstgmygtbstg is naughty because it has a pair (tg) but no repeat with a single letter between them.
     * ieodomkazucvgmuy is naughty because it has a repeating letter with one between (odo), but no pair that appears
     * twice.
     */
    @ParameterizedTest
    @CsvSource({"TestCase4.txt,1", "TestCase5.txt,1","TestCase6.txt,0"})
    void test_run(String filename, long expected) {
        underTest = new Part2();
        testAdvent(filename, expected);
    }

}