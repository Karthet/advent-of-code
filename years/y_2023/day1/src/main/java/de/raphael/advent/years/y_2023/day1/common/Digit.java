package de.raphael.advent.years.y_2023.day1.common;

public enum Digit {
    // Because written numbers are replaced from left to right we keep the string to save combined numbers.
    ONE("one", "1one"),
    TWO("two", "2two"),
    THREE("three", "3three"),
    FOUR("four","4four"),
    FIVE("five","5five"),
    SIX("six","6six"),
    SEVEN("seven","7seven"),
    EIGHT("eight","8eight"),
    NINE("nine","9nine");

    private final String name;
    private final String digitRepresentation;

    Digit(String name, String digitRepresentation) {
        this.name = name;
        this.digitRepresentation = digitRepresentation;
    }

    public String getName() {
        return this.name;
    }

    public String getDigitRepresentation() {
        return this.digitRepresentation;
    }

    @Override
    public String toString() {
        return this.name;
    }

}