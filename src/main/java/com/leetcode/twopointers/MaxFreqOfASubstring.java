package com.leetcode.twopointers;
/*
https://leetcode-cn.com/problems/maximum-number-of-occurrences-of-a-substring/

Given a string s, return the maximum number of occurrences of any substring under the following rules:

The number of unique characters in the substring must be less than or equal to maxLetters.
The substring size must be between minSize and maxSize inclusive.

Constraints:

1 <= s.length <= 10^5
1 <= maxLetters <= 26
1 <= minSize <= maxSize <= min(26, s.length)
s only contains lowercase English letters.
 */

import java.util.HashMap;
import java.util.Map;

class MaxFreqOfASubstring {

    /*
    #[Better]

     */

    /*
    时间复杂度：O(NS)，其中 N 是字符串的长度，S 是 minSize 和 maxSize 的数量级。

    空间复杂度：O(N)
     */
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> counterMap = new HashMap<>();
        int count = 0;
        int[] hash = new int[26];
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            hash[s.charAt(r) - 'a']++;
            if (hash[s.charAt(r) - 'a'] == 1) {
                count++;
            }

            if (r - l + 1 > minSize) {
                hash[s.charAt(l) - 'a']--;
                if (hash[s.charAt(l) - 'a'] == 0) {
                    count--;
                }
                l++;
            }
            if (r - l + 1 == minSize && count <= maxLetters) {
                counterMap.merge(s.substring(l, r + 1), 1, Integer::sum);
            }
        }

        return counterMap.values()
                .stream().mapToInt(i -> i).max().orElse(0);
        //Collection<Integer> counts = counterMap.values();
        //return counts.isEmpty() ? 0 : counts.stream().mapToInt(i -> i).max().getAsInt();
    }
}