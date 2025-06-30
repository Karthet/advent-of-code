package de.raphael.advent.years.y_2015.day16.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.years.y_2015.day16.Day16;
import de.raphael.advent.years.y_2015.day16.common.Sue;
import de.raphael.advent.years.y_2015.day16.mapper.Input2SueMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * As you're about to send the thank you note, something in the MFCSAM's instructions catches your eye. Apparently, it
 * has an outdated retroencabulator, and so the output from the machine isn't exact values - some of them indicate
 * ranges.
 * <p>
 * In particular, the cats and trees readings indicates that there are greater than that many (due to the unpredictable
 * nuclear decay of cat dander and tree pollen), while the pomeranians and goldfish readings indicate that there are
 * fewer than that many (due to the modial interaction of magnetoreluctance).
 * <p>
 * What is the number of the real Aunt Sue?
 */
@Slf4j
public class Part2 extends Programm {

    @Override
    public Object run(List<String> input) {
        return determineCorrectSue(input.stream().map(Input2SueMapper::map).toList());
    }

    private int determineCorrectSue(List<Sue> sues) {
        var sue = Day16.theOneAndOnly;
        var possibleSues = sues.stream().filter(s -> {
            var correct = true;
            if (s.children() != null) {
                correct = s.children().equals(sue.children());
            }
            if (s.cats() != null) {
                correct = s.cats() > sue.cats();
            }
            if (s.samoyeds() != null) {
                correct &= s.samoyeds().equals(sue.samoyeds());
            }
            if (s.pomeranians() != null) {
                correct &= s.pomeranians() < sue.pomeranians();
            }
            if (s.akitas() != null) {
                correct &= s.akitas().equals(sue.akitas());
            }
            if (s.vizslas() != null) {
                correct &= s.vizslas().equals(sue.vizslas());
            }
            if (s.goldfish() != null) {
                correct &= s.goldfish() < sue.goldfish();
            }
            if (s.trees() != null) {
                correct &= s.trees() > sue.trees();
            }
            if (s.cars() != null) {
                correct &= s.cars().equals(sue.cars());
            }
            if (s.perfumes() != null) {
                correct &= s.perfumes().equals(sue.perfumes());
            }
            return correct;
        }).toList();

        if (possibleSues.size() != 1) {
            throw new IllegalStateException((possibleSues.size() > 1 ? "More than one " : "No") + " possible sue: " + possibleSues);
        }

        return possibleSues.get(0).number();
    }

}
