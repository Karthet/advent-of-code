package de.raphael.advent.year.y_2015.day11.common;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordManagerTest {

    /**
     * <p>For example:</p>
     * <ul>
     *     <li>hijklmmn meets the first requirement (because it contains the straight hij) but fails the second
     *     requirement requirement (because it contains i and l).
     *     <li>abbceffg meets the third requirement (because it repeats bb and ff) but fails the first requirement.
     *     <li>abbcegjk fails the third requirement, because it only has one double letter (bb).
     *     <li>The next password after abcdefgh is abcdffaa.
     *     <li>The next password after ghijklmn is ghjaabcc, because you eventually skip all the passwords that start
     *     with ghi..., since i is not allowed.
     * </ul>
     */
    @ParameterizedTest
    @CsvSource({"hijklmmn, false", "abbceffg, false", "abbcegjk, false", "abcdffaa, true", "ghjaabcc, true" })
    void test_check(String input, boolean expected) {

        // given
        var underTest = new PasswordManager();

        // when
        var result = underTest.check(input);

        // then
        assertThat(result).isEqualTo(expected);

    }

}