package com.leetcode.twopointers;

/*
Longest Repeating Character Replacement

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
 

Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.

链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement

---

k: 2
a a b b a a a
l     r

a: 2
b: 2

a c c b b a a a


class Solution {
    private int[] map = new int[26];

    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int charMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            charMax = Math.max(charMax, map[index]);
            if (right - left + 1 > charMax + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }
}

链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/tong-guo-ci-ti-liao-jie-yi-xia-shi-yao-shi-hua-don/
 */

class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int[] chars = new int[26];
        // the max frequency of same character occur in sliding window in history
        int maxFreq = 0;
        while (right < s.length()) {
            int idx = s.charAt(right) - 'A';
            chars[idx]++;
            right++;

            maxFreq = Math.max(maxFreq, chars[idx]);
            if (maxFreq + k < right - left) {
                chars[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return s.length() - left;
    }
}
