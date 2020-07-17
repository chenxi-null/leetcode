package com.leetcode.dp;
/*
In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.

You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.


https://leetcode-cn.com/problems/can-i-win
 */

import java.util.Arrays;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/4/23
 */
public class CanIWin {

    /*
    m: maxChoosableInteger
    n: desiredTotal

    dp[i] = !dp[i-1] && !dp[i-2] ... && !dp[i-m]

    dp[0] = true
    dp[1] = true
    dp[2] = !dp[1] && !dp[0] = false
    dp[3] = !dp[2] && !dp[1] = false (m > 1)
         or !dp[2] = true (m == 1)

    result:
    dp[n] = !dp[n-1] && ... && !dp[n-m]

    O(N^2)
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }

        int len = desiredTotal + 1;
        boolean[] dp = new boolean[len];
        dp[0] = false;
        dp[1] = true;
        for (int i = 2; i < len; i++) {
            boolean allSucceed = true;
            int start = Math.max(i - maxChoosableInteger, 0);
            for (int j = start; j < i; j++) {
                if (!dp[j]) {
                    allSucceed = false;
                    break;
                }
            }
            dp[i] = !allSucceed;
        }
        System.out.println(Arrays.toString(dp));
        return dp[len - 1];
    }
}
