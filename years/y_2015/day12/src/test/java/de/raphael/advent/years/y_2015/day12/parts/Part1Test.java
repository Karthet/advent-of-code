package de.raphael.advent.years.y_2015.day12.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Part1Test extends BaseTest {

    /**
     * <p>For example:</p>
     * <ul>
     * <li>[1,2,3] and {"a":2,"b":4} both have a sum of 6.
     * <li>[[[3]]] and {"a":{"b":4},"c":-1} both have a sum of 3.
     * <li>{"a":[-1,1]} and [-1,{"a":1}] both have a sum of 0.
     * <li>[] and {} both have a sum of 0.
     * </ul>
     */
    @ParameterizedTest
    @CsvSource({"TestCase1.txt,12", "TestCase2.txt,6", "TestCase3.txt,0", "TestCase4.txt,0"})
    void test_run(String filename, int expected) {

        underTest = new Part1();
        testAdvent(filename, expected);

    }
}