package de.raphael.advent.years.y_2015.day6.common;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ToggleLighting implements Lighting {

    HashMap<String, Boolean> bulbs;

    public ToggleLighting() {
        bulbs = new HashMap<>();
    }

    public void toggle(String coordinate) {
        if (bulbs.containsKey(coordinate)) {
            bulbs.put(coordinate, !bulbs.get(coordinate));
        } else {
            bulbs.put(coordinate, true);
        }
    }

    public void turnOn(String coordinate) {
        bulbs.put(coordinate, true);
    }

    public void turnOff(String coordinate) {
        bulbs.put(coordinate, false);
    }

    public int activeLights() {
        AtomicInteger active = new AtomicInteger(0);
        bulbs.forEach((k,v) -> { if (Boolean.TRUE.equals(v)) active.incrementAndGet(); });
        return active.get();
    }

}
