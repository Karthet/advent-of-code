package de.raphael.advent.years.y_2015.day14.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.years.y_2015.day14.common.Race;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * Seeing how reindeer move in bursts, Santa decides he's not pleased with the old scoring system.
 * <p>
 * Instead, at the end of each second, he awards one point to the reindeer currently in the lead. (If there are multiple
 * reindeer tied for the lead, they each get one point.) He keeps the traditional 2503 seconds time limit, of course, as
 * doing otherwise would be entirely ridiculous.
 * <p>
 * Again given the descriptions of each reindeer (in your puzzle input), after exactly 2503 seconds, how many points
 * does the winning reindeer have?
 */
@Slf4j
public class Part2 extends Programm {

    @Override
    public Object run(List<String> input) {
        var race = new Race();
        input.forEach(race::registerReindeer);
        return race.executeWithPoints(2503);
    }

}
