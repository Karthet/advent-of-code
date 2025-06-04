package de.raphael.advent.year.y_2015.day10.common;

public class LookAndSay {

    private LookAndSay() {
        //Singleton
    }

    public static String playRound(String input) {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); ++i) {
            int count = 1;
            while (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                ++i;
                ++count;
            }
            result.append(count).append(input.charAt(i));
        }
        return result.toString();

    }

}
