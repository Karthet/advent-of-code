package de.raphael.advent.years.y_2015.day6.parts;

import de.raphael.advent.years.y_2015.day6.common.BrightnessLighting;

/**
 * <p>You just finish implementing your winning light pattern when you realize you mistranslated Santa's message from
 * Ancient Nordic Elvish.</p>
 * <p>The light grid you bought actually has individual brightness controls; each light can have a brightness of zero
 * or more. The lights all start at zero.</p>
 * <p>The phrase turn on actually means that you should increase the brightness of those lights by 1.</p>
 * <p>The phrase turn off actually means that you should decrease the brightness of those lights by 1, to a minimum of
 * zero.</p>
 * <p>The phrase toggle actually means that you should increase the brightness of those lights by 2.</p>
 * <p>What is the total brightness of all lights combined after following Santa's instructions?</p>
 */
public class Part2 extends BasePart {

    public Part2() {
        lighting = new BrightnessLighting();
    }

}
