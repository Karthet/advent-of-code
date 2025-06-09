package de.raphael.advent.years.y_2015.day14.common;

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
    int points;
    int distance;
    int restTime;
    int timeRan;

    @Override
    public int compareTo(@NonNull Reindeer reindeer) {
        return name.compareTo(reindeer.name);
    }

    private void addPoint() {
        points++;
    }

    private void startRest() {
        restTime = rest;
    }

    public int step(int actualMaxDistance) {

        if (actualMaxDistance != 0 && actualMaxDistance == distance) {
            addPoint();
        }

        if (restTime != 0) {
            restTime--;
        } else {
            timeRan++;
            distance += speed;
            if(timeRan >= duration) {
                timeRan = 0;
                startRest();
            }
        }
        return distance;
    }
}
