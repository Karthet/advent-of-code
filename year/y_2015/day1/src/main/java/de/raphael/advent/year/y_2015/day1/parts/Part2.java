package de.raphael.advent.year.y_2015.day1.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.year.y_2015.day1.common.Logic;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * Now, given the same instructions, find the position of the first character that causes him to enter the basement
 * (floor -1). The first character in the instructions has position 1, the second character has position 2, and so on.
 * </p>
 * <p>For example:</p>
 *  <ul>
 *     <li>) causes him to enter the basement at character position 1.</li>
 *     <li>()()) causes him to enter the basement at character position 5.</li>
 *  </ul>
 * <p>What is the position of the character that causes Santa to first enter the basement?</p>
 * @see <a href="https://adventofcode.com/2015/day/1">Advent of Code</a>
 */
@Slf4j
public class Part2 extends Programm {

    @Override
    public Object run(List<String> input) {

        AtomicInteger sum = new AtomicInteger(1); // +1 cause count starts by zero
        return input.stream()
                .reduce("", String::concat)
                .transform(String::chars)
                .map(Logic::charMapper)
                .takeWhile(e -> sum.addAndGet(e) != -1 )
                .count();

    }

}
