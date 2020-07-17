package com.leetcode.twopointers;
/*
76. Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
---

_  _ _   __ _
ADOBECODEBANC
l    r
   l      r
      l     r

 */

import java.util.HashMap;
import java.util.Map;

class MinWindowSubstring {
    /*
    when not satisfy, frozen left, move right until satisfy
    when satisfy, frozen right, move left until not satisfy
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> charToCntMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            charToCntMap.merge(t.charAt(i), 1, Integer::sum);
        }
        Map<Character, Integer> winCharToCntMap = new HashMap<>();
        int count = 0;

        int l = 0; // inclusive
        int r = 0; // exclusive
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;
        while (r < s.length()) {
            if (count < t.length()) {
                // add into window
                r++;
                char ch = s.charAt(r - 1);
                winCharToCntMap.merge(ch, 1, Integer::sum);
                Integer c = charToCntMap.get(ch);
                if (c != null && winCharToCntMap.get(ch) <= c) {
                    count++;
                }
            }
            while (l < r && count == t.length()) {
                // update the answer
                if (r - l < minLen) {
                    minLen = r - l;
                    startIdx = l;
                }
                // remove from window
                char ch = s.charAt(l);
                winCharToCntMap.compute(ch, (k, v) -> --v);
                Integer c = charToCntMap.get(ch);
                if (c != null && winCharToCntMap.get(ch) < c) {
                    count--;
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? ""
                : s.substring(startIdx, startIdx + minLen);
    }
}