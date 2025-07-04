package de.raphael.advent.years.y_2015.day8.parts;

import de.raphael.advent.core.Programm;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * <p>Space on the sleigh is limited this year, and so Santa will be bringing his list as a digital copy. He needs to
 * know how much space it will take up when stored.</p>
 *
 * <p>It is common in many programming languages to provide a way to escape special characters in strings. For example,
 * C, JavaScript, Perl, Python, and even PHP handle special characters in very similar ways.</p>
 *
 * <p>However, it is important to realize the difference between the number of characters in the code representation of
 * the string literal and the number of characters in the in-memory string itself.</p>
 *
 * <p>For example:</p>
 *  <ul>
 *     <li>"" is 2 characters of code (the two double quotes), but the string contains zero characters.
 *     <li>"abc" is 5 characters of code, but 3 characters in the string data.
 *     <li>"aaa\"aaa" is 10 characters of code, but the string itself contains six "a" characters and a single, escaped
 *     quote character, for a total of 7 characters in the string data.
 *     <li>"\x27" is 6 characters of code, but the string itself contains just one - an apostrophe ('), escaped using
 *     hexadecimal notation.
 *  </ul>
 * <p>Santa's list is a file that contains many double-quoted string literals, one on each line. The only escape
 * sequences used are \\ (which represents a single backslash), \" (which represents a lone double-quote character),
 * and \x plus two hexadecimal characters (which represents a single character with that ASCII code).</p>
 *
 * <p>Disregarding the whitespace in the file, what is the number of characters of code for string literals minus the
 * number of characters in memory for the values of the strings in total for the entire file?</p>
 *
 * <p>For example, given the four strings above, the total number of characters of string code (2 + 5 + 10 + 6 = 23)
 * minus the total number of characters in memory for string values (0 + 3 + 7 + 1 = 11) is 23 - 11 = 12.</p>
 */
@Slf4j
public class Part1 extends Programm {


    @Override
    public Object run(List<String> input) {

        return input.stream()
                .map(s -> {
                    var cleanUp = s.substring(1, s.length() - 1);
                    cleanUp = cleanUp.replaceAll("\\\\\\\\|\\\\\"|\\\\x\\w\\w", "|");
                    return s.length() - cleanUp.length();
                })
                .reduce(Integer::sum)
                .orElse(null);

    }

}
