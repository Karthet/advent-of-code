package de.raphael.advent.years.y_2015.day10.common;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LookAndSayTest {

    /**
     * <p>For example:</p>
     * <pre>
     * 1 becomes 11 (1 copy of digit 1).
     * 11 becomes 21 (2 copies of digit 1).
     * 21 becomes 1211 (one 2 followed by one 1).
     * 1211 becomes 111221 (one 1, one 2, and two 1s).
     * 111221 becomes 312211 (three 1s, two 2s, and one 1).
     * </pre>
     */
    @ParameterizedTest
    @CsvSource({"1,11", "11,21", "21,1211", "1211,111221", "111221,312211"})
    void test_playRound(String fileName, String expected) {

        // when
        var result = LookAndSay.playRound(fileName);

        //then
        assertThat(result).isEqualTo(expected);

    }

}