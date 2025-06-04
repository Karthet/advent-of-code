package de.raphael.advent.year.y_2015.day5.parts;

import de.raphael.advent.common.Programm;

import java.util.List;
import java.util.regex.Pattern;

/**
 * <p>Santa needs help figuring out which strings in his text file are naughty or nice.</p>
 * <p>A nice string is one with all of the following properties:</p>
 * <ul>
 *  <li> It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
 *  <li> It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd
 *  (aa, bb, cc, or dd).
 *  <li> It does <strong>not</strong> contain the strings ab, cd, pq, or xy, even if they are part of one of the other
 *  requirements.
 * </ul>
 * <p>How many strings are nice?</p>
 */
public class Part1 extends Programm {

    @Override
    public Object run(List<String> input) {

        Pattern naughty = Pattern.compile("ab|cd|pq|xy");
        Pattern doublet = Pattern.compile("(.)\\1");
        return input.stream()
                .filter(s -> !naughty.matcher(s).find())
                .filter(s -> doublet.matcher(s).find())
                .filter(this::atLeastThenThreeVowels)
                .count();

    }

    private boolean atLeastThenThreeVowels(String s) {
        return s.length() - s.replaceAll("[aeiou]","").length() >= 3;

    }

}
