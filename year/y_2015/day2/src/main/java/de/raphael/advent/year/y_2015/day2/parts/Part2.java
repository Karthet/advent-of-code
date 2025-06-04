package de.raphael.advent.year.y_2015.day2.parts;

import de.raphael.advent.common.Programm;
import de.raphael.advent.year.y_2015.day2.common.Logic;
import de.raphael.advent.year.y_2015.day2.common.Present;

import java.util.List;

/**
 * <p>The elves are also running low on ribbon. Ribbon is all the same width, so they only have to worry about the
 * length they need to order, which they would again like to be exact.</p>
 * <p>The ribbon required to wrap a present is the shortest distance around its sides, or the smallest perimeter of any
 * one face. Each present also requires a bow made out of ribbon as well; the feet of ribbon required for the perfect
 * bow is equal to the cubic feet of volume of the present. Don't ask how they tie the bow, though; they'll never tell.
 * </p>
 * <p>How many total feet of ribbon should they order?</p>
 */
public class Part2 extends Programm {

    @Override
    public Object run(List<String> input) {
        return input.stream()
                .map(Logic::dimensionStringToPresent)
                .map(Present::calculateRequiredRibbon)
                .reduce(0, Integer::sum);
    }

}
