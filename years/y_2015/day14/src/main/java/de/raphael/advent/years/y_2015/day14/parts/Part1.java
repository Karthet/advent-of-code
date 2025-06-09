package de.raphael.advent.years.y_2015.day14.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.years.y_2015.day14.common.Race;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * This year is the Reindeer Olympics! Reindeer can fly at high speeds, but must rest occasionally to recover their
 * energy. Santa would like to know which of his reindeer is fastest, and so he has them race.
 * <p>
 * Reindeer can only either be flying (always at their top speed) or resting (not moving at all), and always spend whole
 * seconds in either state.l guest list?
 * </p>
 * Given the descriptions of each reindeer (in your puzzle input), after exactly 2503 seconds, what distance has the
 * winning reindeer traveled?
 */
@Slf4j
public class Part1 extends Programm {

    @Override
    public Object run(List<String> input) {
        var race = new Race();
        input.forEach(race::registerReindeer);
        return race.execute(2503);
    }
}
