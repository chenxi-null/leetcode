package com.leetcode.array;

class ReverseString {
    /*
idx:    0, 1, 2, 3, 4

        1, 2, 3, 4, 5,
        5, 4, 3, 2, 1
     */
    public void reverseString(char[] s) {
        if (null == s || s.length <= 1) {
            return;
        }

        for (int i = 0; i < s.length / 2; i++) {
            int j = s.length - 1 - i;
            char t = s[j];
            s[j] = s[i];
            s[i] = t;
        }
    }
}