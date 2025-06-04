package de.raphael.advent.common.io;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

@Slf4j
public class Input {

    private Input() {
        // Singleton
    }

    public static Stream<String> readFile(String filename) {
        var is = Input.class.getClassLoader().getResourceAsStream(filename);
        if (is != null) {
           return new BufferedReader(new InputStreamReader(is)).lines();
        } else {
            log.warn("No Data found! Stopping Application!");
            throw new IllegalStateException();
        }
    }
}
