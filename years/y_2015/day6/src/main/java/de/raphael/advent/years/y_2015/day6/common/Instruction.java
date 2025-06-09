package de.raphael.advent.years.y_2015.day6.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Instruction {

    private Command command;
    private Coordinate start;
    private Coordinate stop;

}
