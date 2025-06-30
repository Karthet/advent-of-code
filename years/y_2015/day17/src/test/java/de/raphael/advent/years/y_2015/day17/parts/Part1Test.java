package de.raphael.advent.years.y_2015.day17.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Part1Test extends BaseTest {

    /**
     * For example, suppose you have containers of size 20, 15, 10, 5, and 5 liters. If you need to store 25 liters,
     * there are four ways to do it:
     * <ul>
     *     <li> 15 and 10
     *     <li> 20 and 5 (the first 5)
     *     <li> 20 and 5 (the second 5)
     *     <li> 15, 5, and 5
     */
    @ParameterizedTest
    @CsvSource({"TestCase1.txt, 4"})
    void test_execute(String filename, int expected) {

        // given
        var part = new Part1();
        part.liters = 25;
        underTest = part;

        // when
        testAdvent(filename, expected);

    }

}