package de.raphael.advent.year.y_2015.day13.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Part1Test extends BaseTest {

    /**
     * <p>
     * For example, suppose you have only four attendees planned, and you calculate their potential happiness as
     * follows:
     * </p>
     * <pre>
     * Alice would gain 54 happiness units by sitting next to Bob.
     * Alice would lose 79 happiness units by sitting next to Carol.
     * Alice would lose 2 happiness units by sitting next to David.
     * Bob would gain 83 happiness units by sitting next to Alice.
     * Bob would lose 7 happiness units by sitting next to Carol.
     * Bob would lose 63 happiness units by sitting next to David.
     * Carol would lose 62 happiness units by sitting next to Alice.
     * Carol would gain 60 happiness units by sitting next to Bob.
     * Carol would gain 55 happiness units by sitting next to David.
     * David would gain 46 happiness units by sitting next to Alice.
     * David would lose 7 happiness units by sitting next to Bob.
     * David would gain 41 happiness units by sitting next to Carol.
     * </pre>
     * <p>
     * Then, if you seat Alice next to David, Alice would lose 2 happiness units (because David talks so much), but
     * David would gain 46 happiness units (because Alice is such a good listener), for a total change of 44.
     * </p>
     * <p>
     * If you continue around the table, you could then seat Bob next to Alice (Bob gains 83, Alice gains 54). Finally,
     * seat Carol, who sits next to Bob (Carol gains 60, Bob loses 7) and David (Carol gains 55, David gains 41).
     * The arrangement looks like this:
     * </p>
     * <pre>
     *      +41 +46
     * +55   David    -2
     * Carol       Alice
     * +60    Bob    +54
     *      -7  +83
     * </pre>
     * <p>
     * After trying every other seating arrangement in this hypothetical scenario, you find that this one is the most
     * optimal, with a total change in happiness of 330.
     * </p>
     */
    @ParameterizedTest
    @CsvSource({"TestCase1.txt,330"})
    void test_run(String filename, int expected) {

        underTest = new Part1();
        testAdvent(filename, expected);

    }
}