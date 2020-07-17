package com.leetcode.dp;
/*
120. Triangle
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

https://leetcode-cn.com/problems/triangle/
 */

import java.util.List;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/4/18
 */
public class Triangle {
    /*
    dp[i][j] = min{ dp[i-1][j-1], dp[i-1][j] } + a[i][j]

    x _ _
    x x _
    x x x

    e.g:
    [[-1],[3,2],[-3,1,-1]]

    -1, __, __
     3,  2, __
    -3,  1, -1

    dp:
    -1,  x, __
     2,  1,  x
    -1,  2,  0
     */
    // TODO Improve: extra space O(N^2) -> O(N)
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int maxWidth = triangle.get(height - 1).size();

        if (height == 1) {
            return triangle.get(0).get(0);
        }

        int[][] dp = new int[height][maxWidth];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < maxWidth; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < height; i++) {
            int w = triangle.get(i).size();
            for (int j = 0; j < w; j++) {
                int left = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int right = dp[i - 1][j];
                dp[i][j] = Math.min(left, right) + triangle.get(i).get(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < maxWidth; j++) {
            min = Math.min(min, dp[height - 1][j]);
        }
        return min;
    }
}
