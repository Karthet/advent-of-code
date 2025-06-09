package de.raphael.advent.years.y_2015.day4.parts;

import de.raphael.advent.core.Programm;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

/**
 * Now find one that starts with six zeroes.
 */
public class Part2 extends Programm {

    @Override
    public Object run(List<String> input) {
        var secret = input.stream().reduce("", String::concat).transform(String::toString);
        var md5 = DigestUtils.md5Hex(secret);
        var additional = -1;
        while (!md5.startsWith("000000")) {
            additional++;
            var nextSecret = secret + additional;
            md5 = DigestUtils.md5Hex(nextSecret);
        }
        return additional;
    }

}
