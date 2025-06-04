package de.raphael.advent.year.y_2015.day7.common;

import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@SuperBuilder
public class BinaryOperation extends Circuit {

    private String leftVariableName;
    private String rightVariableName;
    private Operator operator;

    @Override
    public Integer opearte(Map<String, Circuit> circuitBoard) {
        control(leftVariableName + " " + operator + " " + rightVariableName + " -> " + name);
        if(value == null) {
            value = operator.operate.apply(
                    circuitBoard.get(leftVariableName).opearte(circuitBoard),
                    circuitBoard.get(rightVariableName).opearte(circuitBoard)
            );
        }
        return value;
    }

}
