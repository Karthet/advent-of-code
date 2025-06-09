package de.raphael.advent.years.y_2015.day7.common;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Data
@Slf4j
@SuperBuilder
public abstract class Circuit {

    static List<String> circuitControl = new ArrayList<>();

    String name;
    Integer value;

    public abstract Integer opearte(Map<String, Circuit> circuitBoard);

    public void register(Map<String, Circuit> circuitBoard) {
        circuitBoard.put(name, this);
    }

    void control(String instruction) {
        log.debug(instruction);
    }
}
