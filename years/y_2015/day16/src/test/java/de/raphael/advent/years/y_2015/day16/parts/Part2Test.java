package de.raphael.advent.years.y_2015.day16.parts;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Part2Test {

    @Test
    void testCats() {

        // given
        var input = List.of("Sue 1: cats: 8");

        // when
        var result = new Part2().run(input);

        //
        assertEquals(1, result);

    }


}