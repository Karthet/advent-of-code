package de.raphael.advent.common;

import de.raphael.advent.common.io.Input;

import java.util.List;

public abstract class Programm {

    public abstract Object run(List<String> input);

    public Object run(String fileName) {
        return run(Input.readFile(fileName).toList());
    }

    public Object run() {
        return run("Input.txt");
    }

}
