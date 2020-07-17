package com.leetcode.dp;
/*
221. Maximal Square
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

https://leetcode-cn.com/problems/maximal-square/
 */

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/8
 */
public class MaxSquare {

    /*
   1 1 1 x
   1 1 1 x
   1 1 1 x
   x x x 1
     */
    public int maximalSquare(char[][] matrix) {
        if (null == matrix) {
            return 0;
        }

        int nRow = matrix.length;
        if (nRow == 0) {
            return 0;
        }
        int nColumn = matrix[0].length;

        int[][] dp = new int[nRow][nColumn];

        int maxLen = 0;
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int a = (i - 1 >= 0) ? dp[i - 1][j] : 0;
                    int b = (j - 1 >= 0) ? dp[i][j - 1] : 0;
                    int c = (i - 1 >= 0 && j - 1 >= 0) ? dp[i - 1][j - 1] : 0;
                    dp[i][j] = Math.min(a, Math.min(b, c)) + 1;

                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}
