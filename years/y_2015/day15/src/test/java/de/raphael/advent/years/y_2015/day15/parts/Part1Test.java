package de.raphael.advent.years.y_2015.day15.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Part1Test extends BaseTest {

    /**
     * For instance, suppose you have these two ingredients:
     * <pre>
     * Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8
     * Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3
     * </pre>
     * Then, choosing to use 44 teaspoons of butterscotch and 56 teaspoons of cinnamon (because the amounts of each
     * ingredient must add up to 100) would result in a cookie with the following properties:
     * <ul>
     *   <li> A capacity of 44*-1 + 56*2 = 68
     *   <li> A durability of 44*-2 + 56*3 = 80
     *   <li> A flavor of 44*6 + 56*-2 = 152
     *   <li> A texture of 44*3 + 56*-1 = 76
     * </ul>
     * Multiplying these together (68 * 80 * 152 * 76, ignoring calories for now) results in a total score of 62842880,
     * which happens to be the best score possible given these ingredients. If any properties had produced a negative
     * total, it would have instead become zero, causing the whole score to multiply to zero. <br>
     * Given the ingredients in your kitchen and their properties, what is the total score of the highest-scoring cookie
     * you can make?
     */
    @ParameterizedTest
    @CsvSource({"TestCase1.txt, 62842880"})
    void test_execute(String filename, int expected) {

        underTest = new Part1();
        testAdvent(filename, expected);

    }

}