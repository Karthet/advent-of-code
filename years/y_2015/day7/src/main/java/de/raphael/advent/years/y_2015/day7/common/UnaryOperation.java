package de.raphael.advent.years.y_2015.day7.common;

import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@SuperBuilder
public class UnaryOperation extends Circuit {

    private Operator operator;
    private String variableName;

    @Override
    public Integer opearte(Map<String, Circuit> circuitBoard) {
        control(operator + " " + variableName +  " -> " + name);
        if(value == null) {
            value = operator.operate.apply(circuitBoard.get(variableName).opearte(circuitBoard), null);
        }

        return value;

    }

}
