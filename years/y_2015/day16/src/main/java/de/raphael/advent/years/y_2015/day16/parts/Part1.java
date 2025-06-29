package de.raphael.advent.years.y_2015.day16.parts;

import de.raphael.advent.core.Programm;
import de.raphael.advent.years.y_2015.day16.common.Sue;
import de.raphael.advent.years.y_2015.day16.mapper.Input2SueMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Your Aunt Sue has given you a wonderful gift, and you'd like to send her a thank you card. However, there's a small
 * problem: she signed it "From, Aunt Sue".
 * <p>
 * You have 500 Aunts named "Sue".
 * <p>
 * So, to avoid sending the card to the wrong person, you need to figure out which Aunt Sue (which you conveniently
 * number 1 to 500, for sanity) gave you the gift. You open the present and, as luck would have it, good ol' Aunt Sue
 * got you a My First Crime Scene Analysis Machine! Just what you wanted. Or needed, as the case may be.
 * <p>
 * The My First Crime Scene Analysis Machine (MFCSAM for short) can detect a few specific compounds in a given sample,
 * as well as how many distinct kinds of those compounds there are. According to the instructions, these are what the
 * MFCSAM can detect:
 * <pre>
 * children, by human DNA age analysis.
 * cats. It doesn't differentiate individual breeds.
 * Several seemingly random breeds of dog: samoyeds, pomeranians, akitas, and vizslas.
 * goldfish. No other kinds of fish.
 * trees, all in one group.
 * cars, presumably by exhaust or gasoline or something.
 * perfumes, which is handy, since many of your Aunts Sue wear a few kinds.
 * </pre>
 * In fact, many of your Aunts Sue have many of these. You put the wrapping from the gift into the MFCSAM.
 * It beeps inquisitively at you a few times and then prints out a message on ticker tape:
 * <pre>
 * children: 3
 * cats: 7
 * samoyeds: 2
 * pomeranians: 3
 * akitas: 0
 * vizslas: 0
 * goldfish: 5
 * trees: 3
 * cars: 2
 * perfumes: 1
 * </pre>
 *
 * You make a list of the things you can remember about each Aunt Sue. Things missing from your list aren't zero - you
 * simply don't remember the value.
 * <p>
 * What is the number of the Sue that got you the gift?
 */
@Slf4j
public class Part1 extends Programm {

    Sue theOneAndOnly = new Sue(0,3,7,2,3,0,0,5,3,2,1);

    @Override
    public Object run(List<String> input) {
        return determineCorrectSue(theOneAndOnly, input.stream().map(Input2SueMapper::map).toList());
    }

    private int determineCorrectSue(Sue sue, List<Sue> sues) {
        var possibleSues = sues.stream().filter(s -> {
            var correct = false;
            if (s.children() != null) {
                correct = s.children().equals(sue.children());
            }
            if (s.cats() != null) {
                correct &= s.cats().equals(sue.cats());
            }
            if (s.samoyeds() != null) {
                correct &= s.samoyeds().equals(sue.samoyeds());
            }
            if (s.pomeranians() != null) {
                correct &= s.pomeranians().equals(sue.pomeranians());
            }
            if (s.akitas() != null) {
                correct &= s.akitas().equals(sue.akitas());
            }
            if (s.vizslas() != null) {
                correct &= s.vizslas().equals(sue.vizslas());
            }
            if (s.goldfish() != null) {
                correct &= s.goldfish().equals(sue.goldfish());
            }
            if (s.trees() != null) {
                correct &= s.trees().equals(sue.trees());
            }
            if (s.cars() != null) {
                correct &= s.cars().equals(sue.cars());
            }
            if (s.perfumes() != null) {
                correct &= s.perfumes().equals(sue.perfumes());
            }
            return correct;
        }).toList();

        if(possibleSues.size() != 1) {
            throw new IllegalStateException("More or less than one possible sue: " + possibleSues);
        }

        return possibleSues.get(0).number();
    }

}
