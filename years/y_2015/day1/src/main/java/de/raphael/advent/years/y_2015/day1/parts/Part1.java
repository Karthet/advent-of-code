package de.raphael.advent.years.y_2015.day1.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.years.y_2015.day1.common.Logic;

import java.util.List;

/**
 * <p>Santa is trying to deliver presents in a large apartment building, but he can't find the right floor - the
 * directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows the instructions
 * one character at a time.</p>
 * <p>An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down
 * one floor.</p>
 * <p>The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.</p>
 * <p>For example:</p>
 *  <ul>
 *     <li>(()) and ()() both result in floor 0.</li>
 *     <li>((( and (()(()( both result in floor 3.</li>
 *     <li>))((((( also results in floor 3.</li>
 *     <li>()) and ))( both result in floor -1 (the first basement level).</li>
 *     <li>))) and )())()) both result in floor -3.</li>
 *  </ul>
 * <p>To what floor do the instructions take Santa?</p>
 * @see <a href="https://adventofcode.com/2015/day/1">Advent of Code</a>
 */
public class Part1 extends Programm {

    @Override
    public Object run(List<String> input) {
        return input.stream()
                .reduce("", String::concat)
                .transform(String::chars)
                .map(Logic::charMapper)
                .reduce(0, Integer::sum);
    }

}
