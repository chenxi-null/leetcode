package com.leetcode.dp;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/4/13
 */
@Slf4j
public class LongestCommonSubsequence {

    // too young
    public int _longestCommonSubsequence_(String text1, String text2) {
        /*
        dp[i]: text1 中, 以第 i 个字符结尾的最长公共子串的长度
        dp[i] = max { f(dp[0..i-1] + 1) }
         */
        int[] dp = new int[text1.length()];
        int[] indexes = new int[text1.length()]; // the index of same char in text2
        Arrays.fill(indexes, -1);

        int max;
        int idx;
        for (int i = 0; i < text1.length(); i++) {
            max = 0;
            idx = 0;
            for (int j = 0; j <= i; j++) {
                for (int k = indexes[j] + 1; k < text2.length(); k++) {
                    if (text2.charAt(k) == text1.charAt(i)) {
                        if (dp[j] + 1 > max) {
                            max = dp[j] + 1;
                            idx = k;
                            break;
                        }
                    }
                }
            }
            dp[i] = max;
            indexes[i] = idx;
        }

        log.info(Arrays.toString(dp));
        log.info(Arrays.toString(indexes));
        max = 0;
        for (int len : dp) {
            max = Math.max(len, max);
        }
        return max;
    }

    /*
    dp[i][j] = {
        dp[i-1][j-1] + 1,
        max(dp[i-1][j], dp[i][j-1])
    }
     */
    // to improve: 压缩空间
    public int longestCommonSubsequence(String text1, String text2) {
        int lenX = text1.length() + 1;
        int lenY = text2.length() + 1;
        int[][] dp = new int[lenX][lenY];
        for (int i = 0; i < lenX; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < lenY; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < lenX; i++) {
            for (int j = 1; j < lenY; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[lenX - 1][lenY - 1];
    }
}
