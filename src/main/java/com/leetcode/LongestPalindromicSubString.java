package com.leetcode;
/*
5. Longest Palindromic Substring
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/8
 */
public class LongestPalindromicSubString {

    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }

        int maxLen = 1;
        int startIdx = 0; //inclusive
        int endIdx = 0; //inclusive
        for (int i = 0; i < s.length(); i++) {
            int left, right, halfLen, len;

            left = i - 1;
            right = i + 1;
            halfLen = 0;
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                ++halfLen;
                --left;
                ++right;
            }
            len = halfLen * 2 + 1;
            if (len > maxLen) {
                maxLen = len;
                startIdx = ++left;
                endIdx = --right;
            }

            left = i;
            right = i + 1;
            halfLen = 0;
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                ++halfLen;
                --left;
                ++right;
            }
            len = halfLen * 2;
            if (len > maxLen) {
                maxLen = len;
                startIdx = ++left;
                endIdx = --right;
            }
        }
        return s.substring(startIdx, endIdx + 1);
    }
}
