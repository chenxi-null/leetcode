package com.leetcode;
/*
1160. Find Words That Can Be Formed by Characters
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.


Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation:
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation:
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 */

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/17
 */
public class WordFormedByChar {
    public int countCharacters(String[] words, String chars) {
        int sum = 0;

        int[] counter = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            ++counter[c - 'a'];
        }

        for (String word : words) {
            int[] wordCounter = new int[26];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                ++wordCounter[c - 'a'];
            }

            boolean ok = true;
            for (int j = 0; j < 26; j++) {
                if (wordCounter[j] > counter[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                sum += word.length();
            }
        }
        return sum;
    }
}
