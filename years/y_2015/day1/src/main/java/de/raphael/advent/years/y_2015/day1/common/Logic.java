package de.raphael.advent.years.y_2015.day1.common;

public class Logic {

    private Logic() {
        // Sigleton
    }

    public static int charMapper(int character) {
        if (character == '(') {
            return 1;
        } else if (character == ')') {
            return -1;
        } else {
            return 0;
        }
    }


}
