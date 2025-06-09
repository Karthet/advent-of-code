package de.raphael.advent.years.y_2015.day3.common;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Tour {

    Location current;

    Map<Location, Integer> houses;

    public Tour() {
        current = Location.builder().x(0).y(0).build();
        houses = new HashMap<>();
        houses.put(Location.builder().x(current.getX()).y(current.getY()).build(), 1);
    }

    public void updateTour(Direction direction) {

        direction.updateLocation(current);

        if (houses.containsKey(current)) {
            var value = houses.get(current);
            houses.put(current, value + 1);
        } else {
            houses.put(Location.builder().x(current.getX()).y(current.getY()).build(), 1);
        }

    }

    public int housesVisited() {
        return houses.size();
    }

    public void mergeHouses(Tour tour) {
        houses.putAll(tour.getHouses());
    }



}
