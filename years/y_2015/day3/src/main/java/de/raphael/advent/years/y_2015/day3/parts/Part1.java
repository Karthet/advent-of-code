package de.raphael.advent.years.y_2015.day3.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.years.y_2015.day3.common.Direction;
import de.raphael.advent.years.y_2015.day3.common.Tour;

import java.util.List;

/**
 * <p>Santa is delivering presents to an infinite two-dimensional grid of houses.</p>
 * <p>He begins by delivering a present to the house at his starting location, and then an elf at the North Pole calls
 * him via radio and tells him where to move next. Moves are always exactly one house to the north (^), south (v), east
 * (>), or west (<). After each move, he delivers another present to the house at his new location.</p>
 * <p>However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off,
 * and Santa ends up visiting some houses more than once. How many houses receive at least one present?</p>
 */
public class Part1 extends Programm {

    @Override
    public Object run(List<String> input) {

        var tour = new Tour();
        input.stream()
                .reduce("", String::concat)
                .transform(String::chars)
                .mapToObj(Direction::mapDirection)
                .forEach(tour::updateTour);
        return tour.housesVisited();

    }

}
