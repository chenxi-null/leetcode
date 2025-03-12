/*
 * @lc app=leetcode.cn id=3305 lang=java
 *
 * [3305] Count of Substrings Containing Every Vowel and K Consonants I
 * #Tag/SlidingWindow
 */

// @lc code=start
class Solution {
    public int countOfSubstrings(String word, int k) {
        int left = 0;
        int[] vowelsInWin = new int[5];
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);
        int cntConsonantInWin = 0;
        int ans = 0;
        for (int right = 0; right < word.length(); right++) {
            if (isVowel(word.charAt(right))) {
                ++vowelsInWin[map.get(word.charAt(right))];
            } else {
                ++cntConsonantInWin;
            }
            while (left <= right && cntConsonantInWin > k) {
                if (isVowel(word.charAt(left))) {
                    --vowelsInWin[map.get(word.charAt(left))];
                } else {
                    --cntConsonantInWin;
                }
                ++left;
            }

            if (containsAllVowels(vowelsInWin) && cntConsonantInWin == k) {
                ++ans;
                int[] vowels = vowelsInWin.clone();
                int cnt = 0;
                for (int i = left; i < right; i++) {
                    char c = word.charAt(i);
                    if (!isVowel(c) || --vowels[map.get(c)] <= 0) {
                        break;
                    }
                    ++cnt;
                }
                ans += cnt;
            }
        }    
        return ans;
    }

    boolean containsAllVowels(int[] a) {
        for (int n : a) {
            if (n <= 0) return false;
        }
        return true;
    }

    boolean isVowel(char c) {
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}
// @lc code=end

