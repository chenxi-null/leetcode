//Given a string containing just the characters '(' and ')', find the length of 
//the longest valid (well-formed) parentheses substring. 
//
// Example 1: 
//
// 
//Input: "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()"
// 
//
// Example 2: 
//
// 
//Input: ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()"
// 

/*
"()(()))" 6
"()(())" 6
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    dp[i] longest length of substring [0, i]
    a[i]  the index of begin '(' in current substring
     */
    public int longestValidParentheses(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] s = str.toCharArray();
        int n = s.length;
        int[] dp = new int[n];
        int[] a = new int[n];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (s[i] == ')') {
                if (dp[i - 1] > 0 &&
                        a[i - 1] - 1 >= 0 && s[a[i - 1] - 1] == '(') {

                    dp[i] = dp[i - 1] + 2;
                    if (a[i - 1] - 2 >= 0) {
                        dp[i] += dp[a[i - 1] - 2];
                    }
                    // startIdx + len = endIdx - 1 | a[i] + dp[i] = i + 1;
                    a[i] = i + 1 - dp[i];
                    max = Math.max(max, dp[i]);
                } else if (s[i - 1] == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] += dp[i - 2];
                    }
                    a[i] = i + 1 - dp[i];
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// #[WA] low level: make `2` as `1`, miss checking with demo case