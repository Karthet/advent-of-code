package de.raphael.advent.years.y_2015.day8.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.api.Test;

class Part1Test extends BaseTest {

    /**
     * <p>For example:</p>
     *  <ul>
     *     <li>"" is 2 characters of code (the two double quotes), but the string contains zero characters.
     *     <li>"abc" is 5 characters of code, but 3 characters in the string data.
     *     <li>"aaa\"aaa" is 10 characters of code, but the string itself contains six "a" characters and a single, escaped
     *     quote character, for a total of 7 characters in the string data.
     *     <li>"\x27" is 6 characters of code, but the string itself contains just one - an apostrophe ('), escaped using
     *     hexadecimal notation.
     *  </ul>
     * <p>The four strings above, giving the total number of characters of string code (2 + 5 + 10 + 6 = 23)
     * minus the total number of characters in memory for string values (0 + 3 + 7 + 1 = 11) is 23 - 11 = 12.</p>
     */
    @Test
    void test_run() {
        underTest = new Part1();
        testAdvent("TestCase1.txt", 12);
    }
}