package de.raphael.advent.year.y_2015.day13.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class Person {

    private String name;
    private Map<String, Integer> sympathy;

    public Person(String name) {
        this.name = name;
        sympathy = new HashMap<>();
    }

    public void addRelationship(String name, int sympathy) {
        this.sympathy.put(name, sympathy);
    }

    public int getSympathy(String name) {
        var result = sympathy.get(name);
        return result == null ? 0 : result;
    }

}
