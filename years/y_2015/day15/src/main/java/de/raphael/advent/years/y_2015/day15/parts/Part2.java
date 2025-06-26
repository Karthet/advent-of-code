package de.raphael.advent.years.y_2015.day15.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.years.y_2015.day15.common.Ingredient;
import de.raphael.advent.years.y_2015.day15.common.MixtureHelper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Your cookie recipe becomes wildly popular! Someone asks if you can make another recipe that has exactly 500 calories
 * per cookie (so they can use it as a meal replacement). Keep the rest of your award-winning process the same (100
 * teaspoons, same ingredients, same scoring system).
 * <p>
 * Given the ingredients in your kitchen and their properties, what is the total score of the highest-scoring cookie you
 * can make with a calorie total of 500?
 */
@Slf4j
public class Part2 extends Programm {

    private static final int maxCalories = 500;

    private List<List<Integer>> possibleMixtures = new ArrayList<>();

    @Override
    public Object run(List<String> input) {
        var ingredients = input.stream().map(Ingredient::new).toList();
        possibleMixtures = MixtureHelper.generatePossibleMixtures(ingredients.size());
        return calculateBestRecipeScore(ingredients);
    }

    private int calculateBestRecipeScore(List<Ingredient> ingredients) {

        Set<Integer> scores = new HashSet<>();
        possibleMixtures.forEach(combination -> {

            for (int i = 0; i < combination.size(); i++) {
                ingredients.get(i).setAmount(combination.get(i));
            }

            var cap = ingredients.stream().mapToInt(Ingredient::calcCapacity).sum();
            var flv = ingredients.stream().mapToInt(Ingredient::calcFlavor).sum();
            var txt = ingredients.stream().mapToInt(Ingredient::calcTexture).sum();
            var dur = ingredients.stream().mapToInt(Ingredient::calcDurability).sum();
            var cal = ingredients.stream().mapToInt(Ingredient::calcCalories).sum();

            if (cal == maxCalories) {
                scores.add(Math.max(cap, 0) * Math.max(flv, 0) * Math.max(txt, 0) * Math.max(dur, 0));
            }

        });

        return scores.stream().mapToInt(Integer::intValue).max().orElse(0);

    }

}
