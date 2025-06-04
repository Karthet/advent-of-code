package de.raphael.advent.year.y_2015.day5.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class Part1Test extends BaseTest {

    /**
     * <p><u>Testcase 1:</u></p>
     * ugknbfddgicrmopn is nice because it has at least three vowels (u...i...o...), a double letter (...dd...),
     * and none of the disallowed substrings.
     * <p><u>Testcase 2:</u></p>
     * aaa is nice because it has at least three vowels and a double letter, even though the letters used by different
     * rules overlap.
     * <p><u>Testcase 3:</u></p>
     * jchzalrnumimnmhp is naughty because it has no double letter.
     * haegwjzuvuyypxyu is naughty because it contains the string xy.
     * dvszwmarrgswjxmb is naughty because it contains only one vowel.
     */
    @ParameterizedTest
    @CsvSource({"TestCase1.txt,1", "TestCase2.txt,1","TestCase3.txt,0"})
    void test_run(String filename, long expected) {
        underTest = new Part1();
        testAdvent(filename, expected);
    }
}