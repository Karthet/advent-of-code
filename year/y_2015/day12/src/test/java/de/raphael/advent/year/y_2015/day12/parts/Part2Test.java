package de.raphael.advent.year.y_2015.day12.parts;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Part2Test {

    /**
     *
     * [1,2,3] still has a sum of 6.
     * [1,{"c":"red","b":2},3] now has a sum of 4, because the middle object is ignored.
     * {"d":"red","e":[1,2,3,4],"f":5} now has a sum of 0, because the entire structure is ignored.
     * [1,"red",5] has a sum of 6, because "red" in an array has no effect.
     */
    @ParameterizedTest
    @CsvSource({
            "'[1,2,3]',6",
            "'[1,{\"c\":\"red\",\"b\":2},3]',4",
            "'{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}',0",
            "'[1,\"red\",5]',6"
    })
    void run(String input, int expected) {

        // when
        var result = new Part2().run(List.of(input));

        // then
        assertThat(result).isEqualTo(expected);

    }
}