package de.raphael.advent.years.y_2015.day3.common;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(of = {"x","y"})
public class Location {

    private int x;
    private int y;

    public void increaseX() {
        x++;
    }

    public void decreaseX() {
        x--;
    }

    public void increaseY() {
        y++;
    }

    public void decreaseY() {
        y--;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

}
