package de.raphael.advent.years.y_2015.day14.common;

import de.raphael.advent.core.io.Input;
import de.raphael.advent.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest extends BaseTest {

    /**
     * For example, suppose you have the following Reindeer:
     * <p>
     * <ul>
     * <li>Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.
     * <li>Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.
     * </ul>
     * <p>
     * After one second, Comet has gone 14 km, while Dancer has gone 16 km. After ten seconds, Comet has gone 140 km,
     * while Dancer has gone 160 km. On the eleventh second, Comet begins resting (staying at 140 km), and Dancer
     * continues on for a total distance of 176 km. On the 12th second, both reindeer are resting. They continue to rest
     * until the 138th second, when Comet flies for another ten seconds. On the 174th second, Dancer flies for another
     * 11 seconds.
     * <p>
     * In this example, after the 1000th second, both reindeer are resting, and Comet is in the lead at 1120 km (poor
     * Dancer has only gotten 1056 km by that point). So, in this situation, Comet would win (if the race ended at 1000
     * seconds).
     */
    @ParameterizedTest
    @CsvSource({"TestCase1.txt, 1120"})
    void test_execute(String filename, int expected) {

        // given
        var race = new Race();
        Input.readFile(filename).forEach(race::registerReindeer);

        // when
        var result = race.execute(1000);

        // then
        assertThat(result).isEqualTo(expected);

    }

    /**
     * Given the example reindeer from above, after the first second, Dancer is in the lead and gets one point. He
     * stays in the lead until several seconds into Comet's second burst: after the 140th second, Comet pulls into the
     * lead and gets his first point. Of course, since Dancer had been in the lead for the 139 seconds before that, he
     * has accumulated 139 points by the 140th second.
     * <p>
     * After the 1000th second, Dancer has accumulated 689 points, while poor Comet, our old champion, only has 312. So,
     * with the new scoring system, Dancer would win (if the race ended at 1000 seconds).
     */
    @ParameterizedTest
    @CsvSource({"TestCase1.txt, 689"})
    void test_executeWithPoints(String filename, int expected) {

        // given
        var race = new Race();
        Input.readFile(filename).forEach(race::registerReindeer);

        // when
        var result = race.executeWithPoints(1000);

        // then
        assertThat(result).isEqualTo(expected);

    }
}