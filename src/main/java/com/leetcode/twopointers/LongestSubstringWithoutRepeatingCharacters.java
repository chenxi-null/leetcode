package com.leetcode.twopointers;
/*
#SlidingWindow
#TwoPointers
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/7
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[0] = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        int max = 1;
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);

            dp[i] = dp[i - 1] + 1;
            while (set.contains(ch)) {
                --dp[i];
                set.remove(s.charAt(j++));
            }
            set.add(ch);

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
