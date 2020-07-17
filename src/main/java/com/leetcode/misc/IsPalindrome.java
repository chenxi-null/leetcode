package com.leetcode.misc;

class IsPalindrome {
    /*
    edge cases:
        null
        ''
        x x x
        * * x x x * *
        * * * *

        --- *
        * ---

        ----- * * ----- * ------
              |         |
     */
    public boolean isPalindrome(String s) {
        if (null == s) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && notAlphaOrNum(s.charAt(i))) {
                i++;
            }
            if (i >= j) {
                // there's no alpha char between i and j
                break;
            }
            while (j > i && notAlphaOrNum(s.charAt(j))) {
                j--;
            }
            if (i >= j) {
                // there's no alpha char between i and j
                break;
            }

            if (notEqualWhenIgnoreCase(s, i, j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean notEqualWhenIgnoreCase(String s, int i, int j) {
        return !String.valueOf(s.charAt(i))
                .equalsIgnoreCase(String.valueOf(s.charAt(j)));
    }

    private boolean notAlphaOrNum(char c) {
        boolean isAlpha = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        boolean isNum = c >= '0' && c <= '9';
        return !isAlpha && !isNum;
    }
}