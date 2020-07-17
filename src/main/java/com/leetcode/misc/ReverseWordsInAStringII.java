package com.leetcode.misc;

/*
#string #reverse

186. Reverse Words in a String II
Given an input string , reverse the string word by word.

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note:

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?
 */
class ReverseWordsInAStringII {
    /*
        [3, 4, 5)
        idx < (3+5)/2  == 4
        idx <= 3

        [3, 4, 5, 6)
        idx < (3+6)/2 == 4
        idx <= 3

        ---

        123_456_789
        987_654_321
     */
    public void reverseWords(char[] s) {
        if (s == null || s.length == 1) {
            return;
        }

        reverse(0, s.length, s);

        int i = 0, j = 0;
        while (true) {
            while (j < s.length && s[j] != ' ') {
                ++j;
            }

            reverse(i, j, s);

            if (j >= s.length) {
                break;
            }

            i = j + 1;
            j = i;
        }
    }

    /**
     * @param startIdx inclusive
     * @param endIdx   exclusive
     */
    private void reverse(int startIdx, int endIdx, char[] s) {
        int mid = (endIdx + startIdx) / 2;
        for (int i = startIdx; i < mid; i++) {
            int j = endIdx + startIdx - 1 - i;
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}