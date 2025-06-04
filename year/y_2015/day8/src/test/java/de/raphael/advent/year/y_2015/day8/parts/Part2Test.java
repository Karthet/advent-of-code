package de.raphael.advent.year.y_2015.day8.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.api.Test;

class Part2Test extends BaseTest {

    /**
     * <p>For example:</p>
     *  <ul>
     *     <li>"" encodes to "\"\"", an increase from 2 characters to 6.
     *     <li>"abc" encodes to "\"abc\"", an increase from 5 characters to 9.
     *     <li>"aaa\"aaa" encodes to "\"aaa\\\"aaa\"", an increase from 10 characters to 16.
     *     <li>"\x27" encodes to "\"\\x27\"", an increase from 6 characters to 11.
     *  </ul>
     * <p>Your task is to find the total number of characters to represent the newly encoded strings minus the number
     * of characters of code in each original string literal. For example, for the strings above, the total encoded
     * length (6 + 9 + 16 + 11 = 42) minus the characters in the original code representation (23, just like in the
     * first part of this puzzle) is 42 - 23 = 19.</p>
     */
    @Test
    void test_run() {
        underTest = new Part2();
        testAdvent("TestCase1.txt", 19);
    }
}