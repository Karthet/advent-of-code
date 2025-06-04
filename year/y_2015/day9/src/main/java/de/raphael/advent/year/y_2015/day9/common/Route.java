package de.raphael.advent.year.y_2015.day9.common;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Builder
@EqualsAndHashCode(of = {"name"})
public class Route implements Comparable<Route> {

    String name;
    Map<Route, Integer> ends;

    @Override
    public int compareTo(Route s) {
        return name.compareTo(s.name);
    }

    public void add(Route end, int distance) {
        ends.put(end, distance);
    }

    @Override
    public String toString() {
        return name +
                ends.entrySet().stream()
                        .map(e -> e.getKey().name + "(" + e.getValue().toString() + ")")
                        .collect(Collectors.joining(", ","[","]"));
    }

    public Map<String, Integer> buildRoutePlans() {

        return new HashMap<>(buildRoutePlans(name , 0));

    }

    private Map<String, Integer> buildRoutePlans(String s, int i) {
        var routePlan = new HashMap<String, Integer>();
        boolean last = true;
        for (Map.Entry<Route, Integer> entry : ends.entrySet()) {
            if (!s.contains(entry.getKey().name)) {
                last = false;
                routePlan.putAll(entry.getKey().buildRoutePlans(s + " -> " + entry.getKey().name, i + entry.getValue()));
            }
        }
        return last ? Map.of(s, i) : routePlan;
    }


}
