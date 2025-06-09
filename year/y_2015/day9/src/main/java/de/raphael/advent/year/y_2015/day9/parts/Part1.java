package de.raphael.advent.year.y_2015.day9.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.year.y_2015.day9.common.RoutePlan;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * <p>Every year, Santa manages to deliver all of his presents in a single night.</p>
 * <p>This year, however, he has some new locations to visit; his elves have provided him the distances between every
 * pair of locations. He can start and end at any two (different) locations he wants, but he must visit each location
 * exactly once. What is the shortest distance he can travel to achieve this?</p>
 */
@Slf4j
public class Part1 extends Programm {

    @Override
    public Object run(List<String> input) {

        RoutePlan plan = new RoutePlan();
        input.forEach(plan::extractRoutes);
        plan.buildRoutePlan();
        return plan.getShortesTotalRoute();

    }



}
