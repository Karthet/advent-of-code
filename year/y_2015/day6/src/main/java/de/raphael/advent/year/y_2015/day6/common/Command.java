package de.raphael.advent.year.y_2015.day6.common;

public enum Command {

    ON,
    OFF,
    TOGGLE;

    public static Command stringToCommand(String name) {
        return switch (name) {
            case "toggle" -> TOGGLE;
            case "turn on" -> ON;
            case "turn off" -> OFF;
            default -> throw new IllegalStateException(
                    "No enum constant " + Command.class.getCanonicalName() + " for " + name
            );
        };
    }

}
