package de.raphael.advent.years.y_2015.day12.parts;

import de.raphael.advent.core.Programm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/**
 * <p>Santa's Accounting-Elves need help balancing the books after a recent order. Unfortunately, their accounting
 * software uses a peculiar storage format. That's where you come in.</p>
 * <p>They have a JSON document which contains a variety of things: arrays ([1,2,3]), objects ({"a":1, "b":2}), numbers,
 * and strings. Your first job is to simply find all of the numbers throughout the document and add them together.</p>
 * <p>You will not encounter any strings containing numbers.</p>
 * <p>What is the sum of all numbers in the document?</p>
 */
@Slf4j
public class Part1 extends Programm {

    Pattern digits = Pattern.compile("(\\d+)|(-\\d+)");

    @Override
    public Object run(List<String> input) {

        var result = input.stream().reduce("", String::concat);
        var matcher = digits.matcher(result);
        List<String> parts = new ArrayList<>();

        while (matcher.find()) {
            var group1 = matcher.group(1);
            var group2 = matcher.group(2);

            if  (group1!= null && !group1.isBlank()) {
                parts.add(group1);
            }

            if  (group2!= null && !group2.isBlank()) {
                parts.add(group2);
            }

        }

        return parts.stream().map(Integer::parseInt).reduce(Integer::sum).orElse(0);

    }

}
