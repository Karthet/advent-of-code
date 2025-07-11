package de.raphael.advent.years.y_2015.day6.parts;

import de.raphael.advent.years.y_2015.day6.common.ToggleLighting;

/**
 * <p>Because your neighbors keep defeating you in the holiday house decorating contest year after year, you've decided
 * to deploy one million lights in a 1000x1000 grid.</p>
 * <p>Furthermore, because you've been especially nice this year, Santa has mailed you instructions on how to display
 * the ideal lighting configuration.</p>
 * <p>Lights in your grid are numbered from 0 to 999 in each direction; the lights at each corner are at
 * 0,0, 0,999, 999,999, and 999,0. The instructions include whether to turn on, turn off, or toggle various inclusive
 * ranges given as coordinate pairs. Each coordinate pair represents opposite corners of a rectangle, inclusive; a
 * coordinate pair like 0,0 through 2,2 therefore refers to 9 lights in a 3x3 square. The lights all start turned off.
 * </p>
 * <p>To defeat your neighbors this year, all you have to do is set up your lights by doing the instructions Santa sent
 * you in order.</p>
 * <p>After following the instructions, how many lights are lit?</p>
 */
public class Part1 extends BasePart {

    public Part1() {
        lighting = new ToggleLighting();
    }

}
