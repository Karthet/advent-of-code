package de.raphael.advent.year.y_2015.day10.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.year.y_2015.day10.common.LookAndSay;

import java.util.List;

/**
 * <p>Neat, right? You might also enjoy hearing <a href="https://www.youtube.com/watch?v=ea7lJkEhytA">John Conway
 * talking about this sequence</a> (that's Conway of Conway's Game of Life fame).</p>
 * <p>Now, starting again with the digits in your puzzle input, apply this process 50 times. What is the length of the
 * new result?</p>
 */
public class Part2 extends Programm {

    @Override
    public Object run(List<String> input) {

        var result = input.stream().reduce("", String::concat);
        for (int i = 0; i < 50; i++) {
            result = LookAndSay.playRound(result);
        }

        return result.length();

    }

}
