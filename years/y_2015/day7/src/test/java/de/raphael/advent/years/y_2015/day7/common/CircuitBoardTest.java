package de.raphael.advent.years.y_2015.day7.common;

import de.raphael.advent.core.io.Input;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * For example, here is a simple circuit:
 * <pre>
 * 123 -> x
 * 456 -> y
 * x AND y -> d
 * x OR y -> e
 * x LSHIFT 2 -> f
 * y RSHIFT 2 -> g
 * NOT x -> h
 * NOT y -> i
 * </pre>
 * After it is run, these are the signals on the wires:
 *
 * <pre>
 * d: 72
 * e: 507
 * f: 492
 * g: 114
 * h: 65412
 * i: 65079
 * x: 123
 * y: 456
 * </pre>
 * In little Bobby's kit's instructions booklet (provided as your puzzle input), what signal is ultimately provided to wire a?
 */
class CircuitBoardTest {

    public static CircuitBoard underTest;

    @BeforeAll
    static void init() {
        // given
        underTest = new CircuitBoard();
        Input.readFile("TestCase1.txt").forEach(underTest::registerInstruction);
    }

    @ParameterizedTest
    @CsvSource({"d,72","e,507","f,492","g,114","h,65412","i,65079","x,123","y,456"})
    void test_calculateSignalForWire(String wireName, int expected) {

        // when
        var result = underTest.calculateSignalForWire(wireName);

        // then
        assertThat(result).isEqualTo(expected);

    }
}