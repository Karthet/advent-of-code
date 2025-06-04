package de.raphael.advent.year.y_2015.day2.common;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Data
@Builder
@Slf4j
public class Present {

    private int width;
    private int height;
    private int length;

    public int calcRequiredPaper() {

        var sideA = length * width;
        var sideB = width * height;
        var sideC = height * length;

        return 2 * sideA + 2 * sideB + 2 * sideC + Math.min(Math.min(sideA, sideB), sideC);

    }

    public int calculateRequiredRibbon() {

        var values = new ArrayList<Integer>();
        values.add(width);
        values.add(height);
        values.add(length);
        Collections.sort(values);

        return values.stream().reduce(1, (a, b) -> a * b) + 2 * values.get(0) + 2 * values.get(1);

    }

}
