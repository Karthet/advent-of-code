package de.raphael.advent.years.y_2015.day4.parts;

import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class Part1Test extends BaseTest {

    /**
     * <p><u>Testcase 1:</u></p>
     * If your secret key is abcdef, the answer is 609043, because the MD5 hash of abcdef609043 starts with five zeroes
     * (000001dbbfa...), and it is the lowest such number to do so.
     * <p><u>Testcase 2:</u></p>
     * If your secret key is pqrstuv, the lowest number it combines with to make an MD5 hash starting with five zeroes
     * is 1048970; that is, the MD5 hash of pqrstuv1048970 looks like 000006136ef....
     */
    @ParameterizedTest
    @CsvSource({"TestCase1.txt,609043", "TestCase2.txt,1048970"})
    void test_run(String filename, int expected) {
        underTest = new Part1();
        testAdvent(filename, expected);
    }
}