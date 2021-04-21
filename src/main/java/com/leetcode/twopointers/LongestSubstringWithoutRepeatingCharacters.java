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
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();

        Set<Character> hash = new HashSet<>();
        hash.add(s.charAt(0));
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;

        int l = 0;
        for (int r = 1; r < n; r++) {
            char c = s.charAt(r);

            dp[r] = dp[r - 1] + 1;
            while (hash.contains(c)) {
                //remove from window & update state
                hash.remove(s.charAt(l));
                l++;
                --dp[r];
            }
            //add into window & update state;
            hash.add(c);

            max = Math.max(dp[r], max);
        }
        return max;
    }

    public int lengthOfLongestSubstring_2020(String s) {
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
