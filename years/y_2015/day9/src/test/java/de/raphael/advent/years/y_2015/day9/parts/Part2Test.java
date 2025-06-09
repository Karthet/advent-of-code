package de.raphael.advent.years.y_2015.day9.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.api.Test;

class Part2Test extends BaseTest {

    /**
     * <p>The possible routes are therefore:</p>
     * <pre>
     * Dublin -> London -> Belfast = 982
     * London -> Dublin -> Belfast = 605
     * London -> Belfast -> Dublin = 659
     * Dublin -> Belfast -> London = 659
     * Belfast -> Dublin -> London = 605
     * Belfast -> London -> Dublin = 982
     * </pre>
     * <p>For example, given the distances above, the longest route would be 982 via (for example)
     * Dublin -> London -> Belfast.</p>
     */
    @Test
    void test_run() {
        underTest = new Part2();
        testAdvent("TestCase1.txt", 982);
    }
}