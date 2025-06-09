package de.raphael.advent.years.y_2015.day11.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.years.y_2015.day11.common.PasswordManager;

import java.util.List;

/**
 * Santa's password expired again. What's the next one?
 */
public class Part2 extends Programm {

    @Override
    public Object run(List<String> input) {

        return new PasswordManager().newPassword((String) new Part1().run(input));

    }

}
