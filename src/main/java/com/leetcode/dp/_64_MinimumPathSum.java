package com.leetcode.dp;
/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

https://leetcode-cn.com/problems/minimum-path-sum

---

Solution:

#dp

经典的二维 DP 问题，递推方程很容易想到:

dp(i,j) = min{ dp(i-1,j), dp(i,j-1) } + cost(i,j)

时间复杂度：O(mn)
空间复杂度：O(mn)

有一些减少空间复杂度的技巧:
- O(n): 二维 dp 数组变成一维度的
- O(1): 在给定的数组上原地 (in-place) dp

 */

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/7/23
 */
public class _64_MinimumPathSum {
    public int minPathSum(int[][] a) {
        if (a == null || a.length == 0 || a[0] == null || a[0].length == 0) {
            return 0;
        }
        int nr = a.length;
        int nc = a[0].length;
        int[][] dp = new int[nr][nc];

        dp[0][0] = a[0][0];
        for (int i = 1; i < nr; i++) {
            dp[i][0] = dp[i - 1][0] + a[i][0];
        }
        for (int j = 1; j < nc; j++) {
            dp[0][j] = dp[0][j - 1] + a[0][j];
        }

        for (int i = 1; i < nr; i++) {
            for (int j = 1; j < nc; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + a[i][j];
            }
        }
        return dp[nr - 1][nc - 1];
    }

    // O(N): one-dimensional DP array
    public int _minPathSum(int[][] a) {
        if (a == null || a.length == 0 || a[0] == null || a[0].length == 0) {
            return 0;
        }
        int nr = a.length;
        int nc = a[0].length;
        int[] dp = new int[nc];

        dp[0] = a[0][0];
        // first row
        for (int j = 1; j < nc; j++) {
            dp[j] = dp[j - 1] + a[0][j];
        }

        for (int i = 1; i < nr; i++) {
            dp[0] += a[i][0];
            for (int j = 1; j < nc; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + a[i][j];
            }
        }
        return dp[nc - 1];
    }

    public int __minPathSum(int[][] a) {

    }
}