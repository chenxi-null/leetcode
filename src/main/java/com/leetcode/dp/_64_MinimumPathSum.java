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

#dp
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
        int m = a.length;
        int n = a[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                if (i > 0) {
                    min = dp[i - 1][j];
                }
                if (j > 0) {
                    min = Math.min(min, dp[i][j - 1]);
                }
                dp[i][j] = min;
            }
        }
        return dp[m - 1][n - 1];
    }
}