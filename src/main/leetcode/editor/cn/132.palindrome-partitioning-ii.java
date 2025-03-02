/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 * #tag/DP
 *
 * [Trick] Use DP for palindrome preprocessing.
 */

// @lc code=start
class Solution {

    public int minCut(String s) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (int i=0;i<n;i++) {
            Arrays.fill(g[i], true);
        }
        for (int i=n-1; i>=0; i--) {
            for(int j=i+1; j<n; j++){
                g[i][j] = g[i+1][j-1] && (s.charAt(i) == s.charAt(j));
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (g[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 0; j <= i-1; j++) {
                    if (g[j+1][i]) {
                        dp[i] = Math.min(dp[i], dp[j]+1);
                    }
                }
            }
        }
        return dp[n-1];
    }
}
// @lc code=end

