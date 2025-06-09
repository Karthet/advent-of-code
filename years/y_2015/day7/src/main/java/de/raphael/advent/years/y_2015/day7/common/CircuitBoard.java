package de.raphael.advent.years.y_2015.day7.common;

import lombok.Data;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import static de.raphael.advent.years.y_2015.day7.common.Operator.*;


@Data
public class CircuitBoard {

    private static final int LEFT_SIDE = 0;
    private static final int RIGHT_SIDE = 1;
    private static final Pattern onlyDigitPattern = Pattern.compile("^\\d+$");

    private final Map<String, Circuit> board = new TreeMap<>();

    public void registerInstruction (String instruction){
        var parts = instruction.split("->");
        var circuit = generateCircuit(parts[LEFT_SIDE].trim(), parts[RIGHT_SIDE].trim());
        circuit.register(board);
    }

    public void setWireValue(String wireName, Integer value) {
        if (board.containsKey(wireName)) {
            board.get(wireName).setValue(value);
        }
    }

    private Circuit generateCircuit(String operation, String wireName) {
        var operator = extratctOperator(operation);
        var variables = Arrays.stream(operation.split(operator.operatorName)).map(String::trim).toList();

        return switch (operator) {
            case AND, OR, LSHIFT, RSHIF -> BinaryOperation.builder()
                    .operator(operator)
                    .name(wireName)
                    .leftVariableName(checkForStatic(variables.get(LEFT_SIDE)))
                    .rightVariableName(checkForStatic(variables.get(RIGHT_SIDE)))
                    .build();
            case SIGNAL -> Signal.builder()
                    .name(wireName)
                    .value(Integer.parseInt(variables.get(LEFT_SIDE)))
                    .build();
            case COPY -> UnaryOperation.builder()
                    .name(wireName)
                    .operator(operator)
                    .variableName(variables.get(LEFT_SIDE))
                    .build();
            case NOT -> UnaryOperation.builder()
                    .name(wireName)
                    .operator(operator)
                    .variableName(checkForStatic(variables.get(RIGHT_SIDE)))
                    .build();
        };

    }

    private String checkForStatic(String variable) {
        if(onlyDigitPattern.matcher(variable).matches()) {
            var staticName = "static" + variable;
            board.computeIfAbsent(staticName, k -> Signal.builder()
                    .name(k)
                    .value(Integer.parseInt(variable))
                    .build()
            );

            return staticName;
        }

        return variable;
    }

    public Integer calculateSignalForWire(String wireName) {
        return board.get(wireName).opearte(board);
    }

    private Operator extratctOperator(String operation) {

        if (operation.contains(AND.operatorName)) {
            return AND;
        }
        if (operation.contains(OR.operatorName)) {
            return OR;
        }
        if (operation.contains(LSHIFT.operatorName)) {
            return LSHIFT;
        }
        if (operation.contains(RSHIF.operatorName)) {
            return RSHIF;
        }
        if (operation.contains(NOT.operatorName)) {
            return NOT;
        }
        if (onlyDigitPattern.matcher(operation).find()) {
            return SIGNAL;
        }
        return COPY;

    }

}
