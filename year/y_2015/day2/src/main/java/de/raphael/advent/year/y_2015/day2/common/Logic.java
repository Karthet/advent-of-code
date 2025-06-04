package de.raphael.advent.year.y_2015.day2.common;

public class Logic {

    private static final int LENGTH_ID = 0;
    private static final int WIDTH_ID = 1;
    private static final int HEIGHT_ID = 2;

    private static final int EXPECTED_DIMENSIONS = 3;

    private static final String DIMENSION_SPLITTER = "x";

    private Logic() {
        // Singleton
    }

    public static Present dimensionStringToPresent(String s) {

        var dimensions = s.split(DIMENSION_SPLITTER);

        if(dimensions.length != EXPECTED_DIMENSIONS) {
            throw new IllegalStateException("All present dimensions need three values");
        }

        return Present.builder()
                .length(Integer.parseInt(dimensions[LENGTH_ID]))
                .width(Integer.parseInt(dimensions[WIDTH_ID]))
                .height(Integer.parseInt(dimensions[HEIGHT_ID]))
                .build();

    }

}
