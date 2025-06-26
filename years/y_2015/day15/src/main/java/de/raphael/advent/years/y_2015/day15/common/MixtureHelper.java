package de.raphael.advent.years.y_2015.day15.common;

import java.util.ArrayList;
import java.util.List;

public class MixtureHelper {

    private static final List<List<Integer>> possibleMixtures = new ArrayList<>();

    public static List<List<Integer>> generatePossibleMixtures(int numberOfIngredients) {
        var list = new ArrayList<Integer>();
        list.add(0);
        for(int i = 1; i < numberOfIngredients; i++) {
            list.add(0);
        }
        calcValueCombinations(list, 0, 0, numberOfIngredients);
        return new ArrayList<>(possibleMixtures);
    }

    private static void calcValueCombinations(List<Integer> last, int number, int lastNumber, int numberOfIngredients) {

        if (number >= numberOfIngredients) return;

        var list = new ArrayList<>(last);

        for (int i = 0; i < numberOfIngredients; i++) {

            if (i == number) {
                list.set(i, last.get(i) + 1);
            } else {
                if (number != lastNumber && i == lastNumber && list.stream().reduce(0, Integer::sum) >= 100) {
                    list.set(i, last.get(i) - 1);
                } else {
                    list.set(i, last.get(i));
                }
            }

        }

        int sum = list.stream().reduce(0, Integer::sum);

        if (sum == 100) {
            possibleMixtures.add(list);
        }

        if (sum < 100) {
            for (int i = 0; i < numberOfIngredients; i++) {
                calcValueCombinations(list, number + i, number, numberOfIngredients);
            }
        }

    }

}
