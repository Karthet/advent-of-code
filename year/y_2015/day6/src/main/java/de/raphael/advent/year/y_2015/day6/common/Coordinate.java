package de.raphael.advent.year.y_2015.day6.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinate {

    private int x;
    private int y;

    @Override
    public String toString() {
       return  x + "," + y;
    }

}
