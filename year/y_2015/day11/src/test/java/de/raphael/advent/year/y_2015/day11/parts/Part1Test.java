package de.raphael.advent.year.y_2015.day11.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Part1Test extends BaseTest {

    /**
     * <p>For example:</p>
     * <ul>
     *     <li>The next password after abcdefgh is abcdffaa.
     *     <li>The next password after ghijklmn is ghjaabcc, because you eventually skip all the passwords that start
     *     with ghi..., since i is not allowed.
     * </ul>
     */
    @ParameterizedTest
    @CsvSource({"TestCase1.txt, abcdffaa", "TestCase2.txt, ghjaabcc"})
    void test_run(String filename, String expected) {

        underTest = new Part1();
        testAdvent(filename, expected);

    }
}