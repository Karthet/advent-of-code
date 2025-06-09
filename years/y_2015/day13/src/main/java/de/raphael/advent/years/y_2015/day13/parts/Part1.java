package de.raphael.advent.years.y_2015.day13.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.years.y_2015.day13.common.SeatPlan;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * <p>
 * In years past, the holiday feast with your family hasn't gone so well. Not everyone gets along! This year, you
 * resolve, will be different. You're going to find the optimal seating arrangement and avoid all those awkward
 * conversations.
 * </p>
 * <p>
 * You start by writing up a list of everyone invited and the amount their happiness would increase or decrease if
 * they were to find themselves sitting next to each other person. You have a circular table that will be just big
 * enough to fit everyone comfortably, and so each person will have exactly two neighbors.
 * </p>
 * <p>
 * What is the total change in happiness for the optimal seating arrangement of the actual guest list?
 * </p>
 */
@Slf4j
public class Part1 extends Programm {

    @Override
    public Object run(List<String> input) {

        var seatPlan = new SeatPlan();
        input.forEach(seatPlan::addSetUp);

        return seatPlan.findBestSeatPlan();

    }
}
