package de.raphael.advent.year.y_2015.day13.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.year.y_2015.day13.common.SeatPlan;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * In all the commotion, you realize that you forgot to seat yourself. At this point, you're pretty apathetic toward
 * the whole thing, and your happiness wouldn't really go up or down regardless of who you sit next to. You assume
 * everyone else would be just as ambivalent about sitting next to you, too.
 * <p>
 * So, add yourself to the list, and give all happiness relationships that involve you a score of 0.
 * <p>
 * What is the total change in happiness for the optimal seating arrangement that actually includes yourself?
 */
@Slf4j
public class Part2 extends Programm {

    @Override
    public Object run(List<String> input) {
        var seatPlan = new SeatPlan();
        seatPlan.addMe();
        input.forEach(seatPlan::addSetUp);
        return seatPlan.findBestSeatPlan();
    }

}
