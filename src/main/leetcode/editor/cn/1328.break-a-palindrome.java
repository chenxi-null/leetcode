/*
 * @lc app=leetcode.cn id=1328 lang=java
 *
 * [1328] Break a Palindrome
 */

// @lc code=start
class Solution {
    public String breakPalindrome(String s) {
        if (s.length() <= 1) {
            return "";
        }
        int ansIdx = -1;
        char ansChar = '_';
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != 'a') {
                ansIdx = i;
                ansChar = 'a';
                break;
            }
        }
        if (ansIdx < 0) {
            ansIdx = s.length() - 1;
            ansChar = 'b';
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == ansIdx) {
                ans.append(ansChar);
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
// @lc code=end

