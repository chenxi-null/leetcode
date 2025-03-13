/*
 * @lc app=leetcode.cn id=3306 lang=java
 *
 * [3306] Count of Substrings Containing Every Vowel and K Consonants II
 * #Tag/SlidingWindow
 */

// @lc code=start

import java.util.Map;

class Solution {
    public long countOfSubstrings(String word, int k) {
        // count(k) represnets the total number of substrings that contains every vowel
        //  and at least k consonants. The answer is `count(k) - count(k+1)`.
        return count(word, k) - count(word, k+1);
    }

    long count(String w, int k) {
        int n = w.length();
        long ans = 0;
        Map<Character, Long> vowels = new HashMap<>();
        int cntConsonant = 0;
        int right = 0;
        for (int left = 0; left < n; left++) {
            while ((vowels.size() < 5 || cntConsonant < k) && right < n) {
                char c = w.charAt(right);
                if (isVowel(c)) {
                    vowels.put(c, vowels.getOrDefault(c, 0L)+1);
                } else {
                    ++cntConsonant;
                }
                ++right;
            }
            if (vowels.size() >= 5 && cntConsonant >= k) {
                // window: [left, right) -> count: [right-1, n)
                ans += (n - right + 1);
            }

            char c = w.charAt(left);
            if (isVowel(c)) {
                vowels.put(c, vowels.get(c)-1);
                if (vowels.get(c) == 0L) {
                    vowels.remove(c);
                }
            } else {
                --cntConsonant;
            }
        }
        return ans;
    }

    boolean isVowel(char c) {
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
// @lc code=end

