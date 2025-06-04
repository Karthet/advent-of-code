package de.raphael.advent.year.y_2015.day9.common;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RoutePlan {

    private final Map<String, Route> routes = new TreeMap<>();
    private final Map<String, Integer> plan = new TreeMap<>();

    public void buildRoutePlan() {
        routes.forEach((r,v) -> plan.putAll(v.buildRoutePlans()));
    }

    public void extractRoutes(String description) {

        var descriptionParts = description.split("to|=");
        var from = descriptionParts[0].trim();
        var to = descriptionParts[1].trim();
        var distance = Integer.parseInt(descriptionParts[2].trim());

        var routeFrom = routes.computeIfAbsent(from, k -> Route.builder()
                .name(from)
                .ends(new HashMap<>())
                .build());
        var routeTo  = routes.computeIfAbsent(to, k -> Route.builder()
                .name(to)
                .ends(new HashMap<>())
                .build());
        routeTo.add(routeFrom, distance);
        routeFrom.add(routeTo, distance);

        routes.put(from, routeFrom);
        routes.put(to, routeTo);

    }

    public int getShortesTotalRoute() {
        return plan.entrySet().stream()
                .reduce((r1,r2) -> r1.getValue() < r2.getValue() ? r1 : r2)
                .orElseThrow(() -> new IllegalStateException("No result found!"))
                .getValue();
    }

    public int getLongestTotalRoute() {
        return plan.entrySet().stream()
                .reduce((r1,r2) -> r1.getValue() > r2.getValue() ? r1 : r2)
                .orElseThrow(() -> new IllegalStateException("No result found!"))
                .getValue();
    }

}
