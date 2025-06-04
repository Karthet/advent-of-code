package de.raphael.advent.year.y_2015.day10.parts;

import de.raphael.advent.common.Programm;
import de.raphael.advent.year.y_2015.day10.common.LookAndSay;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * <p>Today, the Elves are playing a game called look-and-say. They take turns making sequences by reading aloud the
 * previous sequence and using that reading as the next sequence. For example, 211 is read as "one two, two ones",
 * which becomes 1221 (1 2, 2 1s).</p>
 * <p>Look-and-say sequences are generated iteratively, using the previous value as input for the next step. For each
 * step, take the previous value, and replace each run of digits (like 111) with the number of digits (3) followed by
 * the digit itself (1).</p>
 */
@Slf4j
public class Part1 extends Programm {

    @Override
    public Object run(List<String> input) {

        var result = input.stream().reduce("", String::concat);
        for (int i = 0; i < 40; i++) {
            result = LookAndSay.playRound(result);
        }

        return result.length();

    }


}
