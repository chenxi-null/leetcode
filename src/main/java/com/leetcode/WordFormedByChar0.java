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

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/17
 */
public class WordFormedByChar0 {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Count> counter = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            counter.merge(c, new Count(1, 0, -1),
                    (k, v) -> {
                        v.total = ++v.total;
                        return v;
                    });
        }

        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            int currWordIdx = i;
            boolean matched = true;
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                Count count = counter.get(c);
                if (null == count) {
                    matched = false;
                    break;
                }

                if (count.currWordIdx != currWordIdx) {
                    count.currWordIdx = currWordIdx;
                    count.used = count.total - 1;
                } else if (count.used > 0) {
                    count.used = count.used - 1;
                } else {
                    matched = false;
                    break;
                }
            }

            if (matched) {
                sum += words[i].length();
            }
        }
        return sum;
    }

    private static class Count {
        int total;
        int used;
        int currWordIdx;

        public Count(int total, int used, int currWordIdx) {
            this.total = total;
            this.used = used;
            this.currWordIdx = currWordIdx;
        }
    }
}
