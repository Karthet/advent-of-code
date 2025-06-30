package de.raphael.advent.years.y_2015.day17.parts;

import de.raphael.advent.core.Programm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * The elves bought too much eggnog again - 150 liters this time. To fit it all into your refrigerator, you'll need to
 * move it into smaller containers. You take an inventory of the capacities of the available containers.
 * <p>
 * Filling all containers entirely, how many different combinations of containers can exactly fit all 150 liters of
 * eggnog?
 */
@Slf4j
public class Part1 extends Programm {

    protected int liters = 150;
    private List<Integer> combination = new ArrayList<>();
    private final List<List<Integer>> validCombinations = new ArrayList<>();
    private final static boolean logEnabled = true;

    @Override
    public Object run(List<String> input) {
        var containers = input.stream().map(Integer::parseInt).sorted().toList();

        for(int i = 0; i < containers.size(); i++) {
            combination = new ArrayList<>();
            calcCombinations(containers, i);
        }

        return validCombinations.size();
    }

    private void calcCombinations(List<Integer> containers, int next) {

        combination.add(containers.get(next));
        var sum = combination.stream().mapToInt(Integer::intValue).sum();

        if(logEnabled) {
            log.info("combination: {} : sum {}", combination, combination.stream().mapToInt(Integer::intValue).sum());
        }
        if (sum == liters) {
            if(logEnabled) {
                log.info("a: {}", combination);
            }
            validCombinations.add(new ArrayList<>(combination));
        } else if (sum < liters) {
            for (int i = next + 1; i < containers.size(); i++) {
                calcCombinations(containers, i);
                if (!combination.isEmpty()) {
                    combination.remove(combination.size() - 1);
                }
            }
        }

    }

}
