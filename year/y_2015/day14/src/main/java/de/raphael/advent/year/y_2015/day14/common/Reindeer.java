package de.raphael.advent.year.y_2015.day14.common;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Reindeer implements Comparable<Reindeer> {

    String name;
    int speed;
    int duration;
    int rest;

    @Override
    public int compareTo(@NonNull Reindeer reindeer) {
        return name.compareTo(reindeer.name);
    }
}
