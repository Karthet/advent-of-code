package de.raphael.advent.years.y_2015.day9.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.api.Test;

class Part1Test extends BaseTest {

    /**
     * <p>For example, given the following distances:</p>
     *<pre>
     * London to Dublin = 464
     * London to Belfast = 518
     * Dublin to Belfast = 141
     * </pre>
     * <p>The possible routes are therefore:</p>
     * <pre>
     * Dublin -> London -> Belfast = 982
     * London -> Dublin -> Belfast = 605
     * London -> Belfast -> Dublin = 659
     * Dublin -> Belfast -> London = 659
     * Belfast -> Dublin -> London = 605
     * Belfast -> London -> Dublin = 982
     * </pre>
     * <p>The shortest of these is London -> Dublin -> Belfast = 605, and so the answer is 605 in this example.</p>
     */
    @Test
    void test_run() {
        underTest = new Part1();
        testAdvent("TestCase1.txt", 605);
    }
}