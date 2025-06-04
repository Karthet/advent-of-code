package de.raphael.advent.year.y_2015.day3.common;


import java.util.function.Consumer;

public enum Direction {

    NORTH("^", Location::increaseY),
    SOUTH("v", Location::decreaseY),
    EAST(">", Location::increaseX),
    WEST("<", Location::decreaseX);

    public final String symbol;
    private final Consumer<Location> updateLocation;

    Direction(String symbol, Consumer<Location> updateLocation) {
        this.symbol = symbol;
        this.updateLocation = updateLocation;
    }

    public void updateLocation(Location current) {
        updateLocation.accept(current);
    }


    public static Direction mapDirection(int symbol) {
        return switch (symbol) {
            case '^' -> NORTH;
            case 'v' -> SOUTH;
            case '>' -> EAST;
            case '<' -> WEST;
            default -> throw new IllegalStateException(
                    "No enum constant " + Direction.class.getCanonicalName() + " for " + symbol
            );
        };
    }
}
