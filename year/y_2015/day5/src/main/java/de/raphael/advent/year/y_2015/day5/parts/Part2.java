package de.raphael.advent.year.y_2015.day5.parts;

import de.raphael.advent.common.Programm;
import java.util.List;

/**
 * <p>Realizing the error of his ways, Santa has switched to a better model of determining whether a string is naughty
 * or nice. None of the old rules apply, as they are all clearly ridiculous.</p>
 * <p>Now, a nice string is one with all of the following properties:</p>
 * <ul>
 *     <li>It contains a pair of any two letters that appears at least twice in the string without overlapping, like
 *     xyxy (xy) or aabcdefgaa (aa), but not like aaa (aa, but it overlaps).</li>
 *     <li>It contains at least one letter which repeats with exactly one letter between them, like xyx, abcdefeghi
 *     (efe), or even aaa.</li>
 * </ul>
 * How many strings are nice under these new rules?
 */
public class Part2 extends Programm {

    @Override
    public Object run(List<String> input) {
       return input.stream()
               .filter(this::containsPariOfTwoLetters)
               .filter(this::containsPairOfLetterWithOneLetterBetween)
               .count();
    }

    public boolean containsPariOfTwoLetters(String s) {

        for(int i = 0; i + 1 < s.length(); i++) {
            var twoLetters = s.substring(i, i+2);
            if (s.indexOf(twoLetters, i+2) > 0) {
                return true;
            }
        }

        return false;

    }

    public boolean containsPairOfLetterWithOneLetterBetween(String s) {

        for(int i = 0; i + 2 < s.length(); i++) {
            var threeLetters = s.substring(i, i + 3);
            if(threeLetters.charAt(0) == threeLetters.charAt(2) && threeLetters.charAt(1) != threeLetters.charAt(0)) {
                return true;
            }
        }

        return false;

    }

}
