package de.raphael.advent.year.y_2015.day7.parts;

import de.raphael.advent.common.Programm;
import de.raphael.advent.year.y_2015.day7.common.CircuitBoard;

import java.util.List;

/**
 * Now, take the signal you got on wire a, override wire b to that signal, and reset the other wires (including wire a).
 * What new signal is ultimately provided to wire a?
 */
public class Part2 extends Programm {

    @Override
    public Object run(List<String> input) {

        CircuitBoard board = new CircuitBoard();
        input.forEach(board::registerInstruction);
        board.setWireValue("b", (Integer)new Part1().run(input));
        return board.calculateSignalForWire("a");

    }

}
