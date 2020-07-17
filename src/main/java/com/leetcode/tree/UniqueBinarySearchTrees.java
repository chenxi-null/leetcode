package com.leetcode.tree;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/8
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }

        // dp[i]: the number of all unique (i) trees
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += dp[j - 1] * dp[i - j];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}
