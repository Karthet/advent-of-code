package de.raphael.advent.years.y_2015.day6.common;

public interface Lighting {

    void toggle(String coordinate);
    void turnOn(String coordinate);
    void turnOff(String coordinate);
    int activeLights();

}
