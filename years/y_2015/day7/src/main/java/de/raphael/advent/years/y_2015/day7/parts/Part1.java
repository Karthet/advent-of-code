package de.raphael.advent.years.y_2015.day7.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.years.y_2015.day7.common.CircuitBoard;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * <p>This year, Santa brought little Bobby Tables a set of wires and bitwise logic gates! Unfortunately, little Bobby
 * is a little under the recommended age range, and he needs help assembling the circuit.</p>
 * <p>Each wire has an identifier (some lowercase letters) and can carry a 16-bit signal (a number from 0 to 65535). A
 * signal is provided to each wire by a gate, another wire, or some specific value. Each wire can only get a signal
 * from one source, but can provide its signal to multiple destinations. A gate provides no signal until all of its
 * inputs have a signal.</p>
 * <p>The included instructions booklet describes how to connect the parts together: x AND y -> z means to connect
 * wires x and y to an AND gate, and then connect its output to wire z.</p>
 * <p>In little Bobby's kit's instructions booklet (provided as your puzzle input), what signal is ultimately provided
 * to wire a?</p>
 */
@Slf4j
public class Part1 extends Programm {

    @Override
    public Object run(List<String> input) {
        CircuitBoard board = new CircuitBoard();
        input.forEach(board::registerInstruction);
        return board.calculateSignalForWire("a");
    }

}
