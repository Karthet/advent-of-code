package de.raphael.advent.years.y_2015.day6.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.year.y_2015.day6.common.*;
import de.raphael.advent.years.y_2015.day6.common.Command;
import de.raphael.advent.years.y_2015.day6.common.Coordinate;
import de.raphael.advent.years.y_2015.day6.common.Instruction;
import de.raphael.advent.years.y_2015.day6.common.Lighting;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public abstract class BasePart extends Programm {

    Pattern pattern = Pattern.compile(
            "(?<command>[a-z ]+) (?<sx>\\d+),(?<sy>\\d+) [a-z]+ (?<ex>\\d+),(?<ey>\\d+)"
    );

    protected Lighting lighting;

    @Override
    public Object run(List<String> input) {

        input.stream()
                .map(this::inputToInstruction)
                .filter(Objects::nonNull)
                .forEach(this::orchastrate);
        return lighting.activeLights();

    }

    private Instruction inputToInstruction(String s) {

        var matcher = pattern.matcher(s);

        if(matcher.matches()) {
            var command = matcher.group("command");
            var startX = Integer.parseInt(matcher.group("sx"));
            var startY = Integer.parseInt(matcher.group("sy"));
            var endX = Integer.parseInt(matcher.group("ex"));
            var endY = Integer.parseInt(matcher.group("ey"));

            return Instruction.builder()
                    .command(Command.stringToCommand(command))
                    .start(new Coordinate(startX, startY))
                    .stop(new Coordinate(endX, endY))
                    .build();
        }

        return null;

    }

    private void orchastrate(Instruction instruction) {
        Consumer<String> operation = switch (instruction.getCommand()) {
            case ON -> lighting::turnOn;
            case OFF -> lighting::turnOff;
            case TOGGLE -> lighting::toggle;
        };

        var start = instruction.getStart();
        var stop = instruction.getStop();

        for (int x = start.getX(); x <= stop.getX(); x++) {
            for (int y = start.getY(); y <= stop.getY(); y++) {
                operation.accept(x + "," + y);
            }
        }

    }

}
