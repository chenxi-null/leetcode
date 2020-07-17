package com.leetcode.dp;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/3
 */
public class EditDistance {

    /*
    dp[i][j] 表示 A 的前 i 个字母和 B 的前 j 个字母之间的编辑距离。

    dp[i][j] =
        if (s1[i-1] == s2[j-1]) then dp[i-1][j-1]
        else then min { dp[i-1][j], dp[ }
     */
    public int minDistance(String word1, String word2) {
        int lenX = word1.length() + 1;
        int lenY = word2.length() + 1;
        int[][] dp = new int[lenX][lenY];

        dp[0][0] = 0;
        for (int j = 1; j < lenY; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < lenX; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < lenX; i++) {
            for (int j = 1; j < lenY; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[lenX - 1][lenY - 1];
    }
}
