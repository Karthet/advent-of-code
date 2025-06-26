package de.raphael.advent.years.y_2015.day15.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Part2Test extends BaseTest {

    /**
     * For example, given the ingredients above, if you had instead selected 40 teaspoons of butterscotch and 60
     * teaspoons of cinnamon (which still adds to 100), the total calorie count would be 40*8 + 60*3 = 500. The total
     * score would go down, though: only 57600000, the best you can do in such trying circumstances.
     */
    @ParameterizedTest
    @CsvSource({"TestCase1.txt, 57600000"})
    void test_execute(String filename, int expected) {

        underTest = new Part2();
        testAdvent(filename, expected);

    }

}