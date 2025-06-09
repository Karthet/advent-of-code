package de.raphael.advent.years.y_2015.day3.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.years.y_2015.day3.common.Direction;
import de.raphael.advent.years.y_2015.day3.common.Tour;

import java.util.List;

/**
 * <p>The next year, to speed up the process, Santa creates a robot version of himself, Robo-Santa, to deliver presents
 * with him.</p>
 * <p>Santa and Robo-Santa start at the same location (delivering two presents to the same starting house), then take
 * turns moving based on instructions from the elf, who is eggnoggedly reading from the same script as the previous
 * year.</p>
 * <p>This year, how many houses receive at least one present?</p>
 */
public class Part2 extends Programm {

    private boolean toggle;
    Tour santa;
    Tour bot;

    public Part2() {
        toggle = true;
        santa = new Tour();
        bot = new Tour();
    }

    @Override
    public Object run(List<String> input) {

        input.stream()
                .reduce("", String::concat)
                .transform(String::chars)
                .mapToObj(Direction::mapDirection)
                .forEach(this::toggleMove);

        santa.mergeHouses(bot);

        return santa.housesVisited();
    }

    private void toggleMove(Direction direction) {

        if (toggle) {
            santa.updateTour(direction);
        } else {
            bot.updateTour(direction);
        }

        toggle = !toggle;

    }


}
