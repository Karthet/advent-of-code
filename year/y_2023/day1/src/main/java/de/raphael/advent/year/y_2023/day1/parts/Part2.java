package de.raphael.advent.year.y_2023.day1.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.year.y_2023.day1.common.Logic;

import java.util.List;

public class Part2 extends Programm
{
    @Override
    public Object run(List<String> input) {
        return input.stream()
                .map(Logic::extendedDigitMapper)
                .reduce(0, Integer::sum);
    }

}
