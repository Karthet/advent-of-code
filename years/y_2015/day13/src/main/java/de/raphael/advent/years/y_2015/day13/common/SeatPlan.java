package de.raphael.advent.years.y_2015.day13.common;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Data
@Slf4j
public class SeatPlan {

    Pattern digit = Pattern.compile("(\\d+)");
    Map<String, Person> persons;

    public SeatPlan() {
        persons = new HashMap<>();
    }

    public void addMe() {
        var name = "Me";
        var sympathy = 0;
        var me = Person.builder()
                .name(name)
                .sympathy(
                        persons.values().stream()
                                .map(p -> {
                                    p.addRelationship(name, sympathy);
                                    return new AbstractMap.SimpleEntry<>(p.getName(), sympathy);
                                })
                                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                )
                .build();
        persons.put(me.getName(), me);
    }

    public void addSetUp(String setUp) {
        var personName = setUp.substring(0, setUp.indexOf(" "));
        var potentialNeighbour = setUp.substring(setUp.lastIndexOf(" ") + 1,
                setUp.endsWith(".") ? setUp.lastIndexOf(".") : setUp.length());
        var positiveRelationship = setUp.contains("gain");
        var matcher = digit.matcher(setUp);
        var sympathy = matcher.find() ?
                ((positiveRelationship ? 1 : -1) * Integer.parseInt(matcher.group())) :
                0;

        var person = persons.computeIfAbsent(personName, Person::new);
        person.addRelationship(potentialNeighbour, sympathy);
    }

    public int findBestSeatPlan() {
        var plans = new HashMap<String, Integer>();
        var guests = new ArrayList<>(persons.keySet().stream().toList());
        calcSeatPlan(plans, 0, "", guests, guests.stream().findFirst().orElse(""));
        log.info("#Plans: {}", plans.size());
        return plans.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .orElse(0);
    }

    private void calcSeatPlan(Map<String, Integer> seatCombinations,
                              int depth,
                              String combination,
                              Collection<String> guests,
                              String first) {
        List<String> test = new ArrayList<>(guests);
        if (depth == persons.size()) {
            seatCombinations.put(combination, calcSympathyScore(combination));
        } else {
            while (!test.isEmpty()) {
                var tmp = test.remove(0);
                if (!combination.contains(tmp)) {
                    if (depth == 0) {
                        if (tmp.equals(first)) {
                            calcSeatPlan(seatCombinations, depth + 1, tmp, test, first);
                        }
                    } else {
                        calcSeatPlan(seatCombinations, depth + 1, combination + "<->" + tmp, guests, first);
                    }
                }
            }
         }
    }

    private Integer calcSympathyScore(String combination) {
        var parts = combination.split("<->");
        var sum = 0;
        if (parts.length > 1) {
            for (int i = 0; i < parts.length; i++) {
                var person = persons.get(parts[i]);
                var leftNeighbor = i - 1 >= 0 ? parts[i - 1] : parts[parts.length - 1];
                var rightNeighbor = i + 1 < parts.length ? parts[i + 1] : parts[0];
                sum += person.getSympathy(leftNeighbor) + person.getSympathy(rightNeighbor);
            }
        }
        return sum;
    }

}
