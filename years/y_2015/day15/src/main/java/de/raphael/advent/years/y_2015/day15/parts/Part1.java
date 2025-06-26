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
 * Today you set out on the task of perfecting your milk-dunking cookie recipe. All you have to do is find the right
 * balance of ingredients. <br/>
 * Your recipe leaves room for exactly 100 teaspoons of ingredients. You make a list of the remaining ingredients you
 * could use to finish the recipe (your puzzle input) and their properties per teaspoon:
 * <ul>
 *   <li> capacity (how well it helps the cookie absorb milk)
 *   <li> flavor (how tasty it makes the cookie)
 *   <li> texture (how it improves the feel of the cookie)
 *   <li> calories (how many calories it adds to the cookie)
 * </ul>
 * You can only measure ingredients in whole-teaspoon amounts accurately, and you have to be accurate so you can
 * reproduce your results in the future. The total score of a cookie can be found by adding up each of the properties
 * (negative totals become 0) and then multiplying together everything except calories.
 */
@Slf4j
public class Part1 extends Programm {

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

            scores.add(Math.max(cap, 0) * Math.max(flv, 0) * Math.max(txt, 0) * Math.max(dur, 0));

        });

        return scores.stream().mapToInt(Integer::intValue).max().orElse(0);

    }
}
