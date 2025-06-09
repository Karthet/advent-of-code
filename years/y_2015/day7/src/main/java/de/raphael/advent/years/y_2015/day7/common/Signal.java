package de.raphael.advent.years.y_2015.day7.common;

import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@SuperBuilder
@Slf4j
public class Signal extends Circuit {

    @Override
    public Integer opearte(Map<String, Circuit> circuitBoard) {
        control(value + " -> " + name);
        return Operator.SIGNAL.operate.apply(value, null);
    }


}
