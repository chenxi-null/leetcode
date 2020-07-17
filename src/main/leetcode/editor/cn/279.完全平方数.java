/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int m = (int) Math.sqrt(n);
        // dp(i) = min { dp(i - q) }  + 1
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= m && j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
// @lc code=end
/*
n: 12
m: 3 (1, 4, 9)

0: 0
1: 1
2: 2
3: 3
4: 1
 */

