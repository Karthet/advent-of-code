package de.raphael.advent.year.y_2015.day8.parts;

import de.raphael.advent.core.Programm;
import java.util.List;
import java.util.regex.Pattern;

/**
 * <p>Now, let's go the other way. In addition to finding the number of characters of code, you should now encode each
 * code representation as a new string and find the number of characters of the new encoded representation, including
 * the surrounding double quotes.</p>
 */
public class Part2 extends Programm {

    private static final Pattern backslash = Pattern.compile("\\\\");
    private static final Pattern quote = Pattern.compile("\"");

    @Override
    public Object run(List<String> input) {

        return input.stream()
                .map(s -> {
                    var changed = backslash.matcher(s).replaceAll("\\\\\\\\");
                    changed = quote.matcher(changed).replaceAll("\\\\\"");
                    changed = String.format("\"%s\"", changed);
                    return changed.length() - s.length();
                })
                .reduce(Integer::sum)
                .orElse(null);

    }

}
