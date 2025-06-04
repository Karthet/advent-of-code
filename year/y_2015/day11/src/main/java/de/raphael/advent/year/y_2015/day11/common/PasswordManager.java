package de.raphael.advent.year.y_2015.day11.common;

import java.util.regex.Pattern;

public class PasswordManager {

    Pattern consecutiveIncreasing = Pattern.compile("(abc|bcd|cde|def|efg|fgh|pqr|qrs|rst|stu|tuv|uvw|vwx|wxy|xyz)");
    Pattern forbiddenLetters = Pattern.compile("([ilo])");
    Pattern doublet = Pattern.compile("(.)\\1");

    public String newPassword(String password) {

        var pwd = password;
        pwd = increment(pwd.toCharArray(), pwd.length() - 1);
        while (!check(pwd)) {
            pwd = increment(pwd.toCharArray(), pwd.length() - 1);
            if (forbiddenLetters.matcher(pwd).find()) {
                pwd = recalc(pwd.toCharArray());
            }
        }

        return pwd;
    }

    private String recalc(char[] charArray) {

        boolean startReplacing = false;
        for (int i = 0; i < charArray.length; i++) {

            if (startReplacing) {
                charArray[i] = 'a';
            }

            if (!startReplacing && forbiddenLetters.matcher(String.valueOf(charArray[i])).matches()) {
                charArray[i]++;
                startReplacing = true;
            }

        }

        return String.valueOf(charArray);

    }

    protected boolean check(String pwd) {

        return consecutiveIncreasing.matcher(pwd).find()
                && !forbiddenLetters.matcher(pwd).find()
                && doublet.matcher(pwd).results().count() > 1
                && checkDifferentDoublet(pwd);

    }

    private boolean checkDifferentDoublet(String pwd) {

        String group = "";
        var matcher = doublet.matcher(pwd);
        while (matcher.find()) {
            if (group.isBlank()) {
                group = matcher.group();
            } else if (!group.equals(matcher.group())) {
                return true;
            }
        }

        return false;
    }

    private String increment(char[] pwd, int charIndex) {

        var c = pwd[charIndex];
        if (c == 'z') {
            if (charIndex - 1 >= 0) {
                pwd[charIndex] = 'a';
                return increment(pwd, --charIndex);
            }
        } else {
            pwd[charIndex] = ++c;
        }
        return String.valueOf(pwd);

    }

}
