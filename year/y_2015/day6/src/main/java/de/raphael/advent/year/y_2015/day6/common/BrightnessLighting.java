package de.raphael.advent.year.y_2015.day6.common;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class BrightnessLighting implements Lighting {

    HashMap<String, Integer> bulbs;

    public BrightnessLighting() {
        bulbs = new HashMap<>();
    }

    @Override
    public void toggle(String coordinate) {
        if (bulbs.containsKey(coordinate)) {
            bulbs.put(coordinate, bulbs.get(coordinate) + 2);
        } else {
            bulbs.put(coordinate, 2);
        }
    }

    @Override
    public void turnOn(String coordinate) {
        if(bulbs.containsKey(coordinate)) {
            bulbs.put(coordinate, bulbs.get(coordinate) + 1);
        } else {
            bulbs.put(coordinate, 1);
        }
    }

    @Override
    public void turnOff(String coordinate) {
        if(bulbs.containsKey(coordinate)) {
            var value = bulbs.get(coordinate);
            if (value > 0) {
                bulbs.put(coordinate, bulbs.get(coordinate) -1);
            }
        }
    }

    @Override
    public int activeLights() {
        AtomicInteger sum = new AtomicInteger(0);
        bulbs.forEach((k,v) -> sum.addAndGet(v));
        return sum.get();
    }

}
