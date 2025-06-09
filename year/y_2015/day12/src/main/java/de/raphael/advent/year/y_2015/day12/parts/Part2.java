package de.raphael.advent.year.y_2015.day12.parts;

import de.raphael.advent.core.Programm;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <p>Uh oh - the Accounting-Elves have realized that they double-counted everything red.</p>
 * <p>Ignore any object (and all of its children) which has any property with the value "red". Do this only for objects
 * ({...}), not arrays ([...]).</p>
 */
@Slf4j
public class Part2 extends Programm {

    Pattern digit = Pattern.compile("(\\d+|-\\d+)");
    Pattern curls = Pattern.compile("\\{");
    Pattern cleanUp = Pattern.compile(" ");

    @Override
    public Object run(List<String> input) {
        var test = input.stream().reduce(String::concat).orElse("");

        while (test.contains("{")) {
            int j = 0;
            int lastOpen = -1;
            while (test.indexOf("{", j) != -1) {
                var close = test.indexOf("}", j);
                var open = test.indexOf("{", j);
                if (close < open) {
                    var sub = test.substring(lastOpen, close + 1);
                    test = replaceSub(sub, test);
                    j = test.indexOf("{", lastOpen);
                    lastOpen = j;
                } else {
                    lastOpen = open;
                    j = open + 1;
                }
            }
            test = cleanUp.matcher(test).replaceAll("");
            if (curls.matcher(test).results().count() == 1) {
                var sub = test.substring(test.indexOf("{"), test.indexOf("}") + 1);
                test = replaceSub(sub, test);
            }
        }

        return new Part1().run(List.of(test));

    }

    private String replaceSub (String sub, String test) {
        var matcher = digit.matcher(sub);
        var replacement = "";
        if (sub.contains(":\"red\"") || matcher.results().findAny().isEmpty()) {
            replacement = " ".repeat(sub.length());
        } else {
            matcher.reset();
            replacement = matcher.results()
                    .map(MatchResult::group)
                    .collect(Collectors.joining(",","[", "]"));
            replacement = replacement + " ".repeat(sub.length() - replacement.length());
        }
        return test.replace(sub, replacement);
    }

}
