package de.raphael.advent.year.y_2023.day1.common;


import java.util.TreeMap;

public class Logic {

    private Logic() {
        // Singleton
    }

    public static Integer extendedDigitMapper(String s) {

        var orderedMap = new TreeMap<Integer, Digit>();
        orderedMap.put(s.indexOf(Digit.ONE.getName()), Digit.ONE);
        orderedMap.put(s.indexOf(Digit.TWO.getName()), Digit.TWO);
        orderedMap.put(s.indexOf(Digit.THREE.getName()), Digit.THREE);
        orderedMap.put(s.indexOf(Digit.FOUR.getName()), Digit.FOUR);
        orderedMap.put(s.indexOf(Digit.FIVE.getName()), Digit.FIVE);
        orderedMap.put(s.indexOf(Digit.SIX.getName()), Digit.SIX);
        orderedMap.put(s.indexOf(Digit.SEVEN.getName()), Digit.SEVEN);
        orderedMap.put(s.indexOf(Digit.EIGHT.getName()), Digit.EIGHT);
        orderedMap.put(s.indexOf(Digit.NINE.getName()), Digit.NINE);
        orderedMap.remove(-1); // remove not occurring Entry

        var replacement = s;
        for(var entry : orderedMap.entrySet()) {
            replacement = replacement.replaceAll(entry.getValue().getName(), entry.getValue().getDigitRepresentation());
        }

        return simpleDigitMapper(replacement);

    }

    public static Integer simpleDigitMapper(String s) {

        var trimmed = s.replaceAll("[^\\d]", "");
        if (trimmed.length() > 1) {
            return Integer.parseInt(trimmed.charAt(0) + trimmed.substring(trimmed.length() - 1));
        } else {
            return Integer.parseInt(trimmed + trimmed);
        }

    }

}
