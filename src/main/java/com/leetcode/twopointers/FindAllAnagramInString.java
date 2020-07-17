package com.leetcode.twopointers;
/*
https://leetcode-cn.com/problems/find-all-anagrams-in-a-string

438. Find All Anagrams in a String
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"DuplicatedCode", "DuplicateExpressions"})
class FindAllAnagramInString {

    /*
    https://juejin.im/post/5cccc9d1f265da0384129e5f#heading-2

    #[Better] way to determine if current window satisfy condition
    O(26) -> O(1):   hash + count


     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() < 1) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();

        // the number of letter that satisfy the condition in window
        int count = 0;

        int[] hash = new int[26];
        for (int i = 0; i < p.length(); i++) {
            hash[p.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = 0;
        for (; r < s.length(); r++) {
            //add char into window
            int idx = s.charAt(r) - 'a';
            hash[idx]--;
            if (hash[idx] >= 0) {
                count++;
            }

            // expand or move window
            if (r + 1 > p.length()) {
                //remove char from window -> move window
                int idx2 = s.charAt(l) - 'a';
                hash[idx2]++;
                if (hash[idx2] > 0) {
                    count--;
                }
                l++;
            }

            if (count == p.length()) {
                ans.add(l);
            }
        }
        return ans;
    }


    public List<Integer> _findAnagrams(String s, String p) {
        if (s == null || s.length() < 1) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();

        int[] charsInP = new int[26];
        for (int i = 0; i < p.length(); i++) {
            charsInP[p.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = 0;
        int[] charsInWindow = new int[26];
        for (; r < s.length(); r++) {
            //add char into charsInWindow
            charsInWindow[s.charAt(r) - 'a']++;

            if (r - l + 1 > p.length()) {
                //remove char from charsInWindow
                charsInWindow[s.charAt(l) - 'a']--;
                l++;
            }

            if (r - l + 1 == p.length()) {
                boolean matched = true;
                for (int i = 0; i < 26; i++) {
                    if (charsInWindow[i] != charsInP[i]) {
                        matched = false;
                        break;
                    }
                }
                if (matched) {
                    ans.add(l);
                }
            }
        }
        return ans;
    }
}