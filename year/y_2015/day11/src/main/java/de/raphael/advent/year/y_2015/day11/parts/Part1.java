package de.raphael.advent.year.y_2015.day11.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.year.y_2015.day11.common.PasswordManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * <p>Santa's previous password expired, and he needs help choosing a new one.</p>
 * <p>To help him remember his new password after the old one expires, Santa has devised a method of coming up with a
 * password based on the previous one. Corporate policy dictates that passwords must be exactly eight lowercase letters
 * (for security reasons), so he finds his new password by incrementing his old password string repeatedly until it is
 * valid.</p>
 * <p>Incrementing is just like counting with numbers: xx, xy, xz, ya, yb, and so on. Increase the rightmost letter one
 * step; if it was z, it wraps around to a, and repeat with the next letter to the left until one doesn't wrap around.
 * </p>
 * <p>Unfortunately for Santa, a new Security-Elf recently started, and he has imposed some additional password
 * requirements:</p>
 * <ul>
 *     <li>Passwords must include one increasing straight of at least three letters, like abc, bcd, cde, and so on, up
 *     to xyz. They cannot skip letters; abd doesn't count.
 *     <li>Passwords may not contain the letters i, o, or l, as these letters can be mistaken for other characters and
 *     are therefore confusing.
 *     <li>Passwords must contain at least two different, non-overlapping pairs of letters, like aa, bb, or zz.
 * </ul>
 * Given Santa's current password (your puzzle input), what should his next password be?
 */
@Slf4j
public class Part1 extends Programm {

    @Override
    public Object run(List<String> input) {

        var pwd = input.stream().reduce("", String::concat).toLowerCase();
        return new PasswordManager().newPassword(pwd);

    }




}
