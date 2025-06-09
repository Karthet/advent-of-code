package de.raphael.advent.years.y_2015.day4.parts;

import de.raphael.advent.core.Programm;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

/**
 * <p>Santa needs help mining some AdventCoins (very similar to bitcoins) to use as gifts for all the economically
 * forward-thinking little girls and boys.</p>
 * <p>To do this, he needs to find MD5 hashes which, in hexadecimal, start with at least five zeroes. The input to the
 * MD5 hash is some secret key (your puzzle input, given below) followed by a number in decimal. To mine AdventCoins,
 * you must find Santa the lowest positive number (no leading zeroes: 1, 2, 3, ...) that produces such a hash.</p>
 */
public class Part1 extends Programm {

    @Override
    public Object run(List<String> input) {
        var secret = input.stream().reduce("", String::concat).transform(String::toString);
        var md5 = DigestUtils.md5Hex(secret);
        var additional = -1;
        while (!md5.startsWith("00000")) {
            additional++;
            var nextSecret = secret + additional;
            md5 = DigestUtils.md5Hex(nextSecret);
        }
        return additional;
    }

}
