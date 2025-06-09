package de.raphael.advent.year.y_2015.day9.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.year.y_2015.day9.common.RoutePlan;

import java.util.List;

/**
 * <p>The next year, just to show off, Santa decides to take the route with the longest distance instead.</p>
 * <p>He can still start and end at any two (different) locations he wants, and he still must visit each location
 * exactly once.</p>
 * <p>What is the distance of the longest route?</p>
 */
public class Part2 extends Programm {

    @Override
    public Object run(List<String> input) {

        RoutePlan plan = new RoutePlan();
        input.forEach(plan::extractRoutes);
        plan.buildRoutePlan();
        return plan.getLongestTotalRoute();

    }

}
