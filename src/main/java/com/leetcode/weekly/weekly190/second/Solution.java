package com.leetcode.weekly.weekly190.second;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxVowels("abciiidef", 3));
        System.out.println(new Solution().maxVowels("aeiou", 2));
        System.out.println(new Solution().maxVowels("rhythms", 2));
    }

    public int maxVowels(String s, int k) {
        int l = 0;
        int r = 0;
        int max = 0;
        int count = 0;
        for (; r < s.length(); r++) {
            if (isVowel(s.charAt(r))) {
                count++;
            }

            if (r - l + 1 > k) {
                if (isVowel(s.charAt(l))) {
                    count--;
                }
                l++;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}