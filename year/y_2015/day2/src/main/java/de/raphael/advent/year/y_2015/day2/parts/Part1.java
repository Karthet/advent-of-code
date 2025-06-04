package de.raphael.advent.year.y_2015.day2.parts;

import de.raphael.advent.common.Programm;
import de.raphael.advent.year.y_2015.day2.common.Logic;
import de.raphael.advent.year.y_2015.day2.common.Present;

import java.util.List;

/**
 * <p>The elves are running low on wrapping paper, and so they need to submit an order for more. They have a list of
 * the dimensions (length l, width w, and height h) of each present, and only want to order exactly as much as they
 * need.</p>
 * <p>Fortunately, every present is a box (a perfect right rectangular prism), which makes calculating the required
 * wrapping paper for each gift a little easier: find the surface area of the box, which is 2*l*w + 2*w*h + 2*h*l.
 * The elves also need a little extra paper for each present: the area of the smallest side.</p>
 * <p>All numbers in the elves' list are in feet. How many total square feet of wrapping paper should they order?</p>
 */
public class Part1 extends Programm {

    @Override
    public Object run(List<String> input) {

        return input.stream()
                .map(Logic::dimensionStringToPresent)
                .map(Present::calcRequiredPaper)
                .reduce(0, Integer::sum);

    }

}
