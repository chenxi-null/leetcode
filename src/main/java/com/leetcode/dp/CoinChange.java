package com.leetcode.dp;
/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.

https://leetcode-cn.com/problems/coin-change
 */

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/8
 */
public class CoinChange {
    /*
    0-1:

    F(c,t): 从前 c 个硬币里凑成金额 t，最少的硬币个数

    第 c 个硬币是否放入

    F[c][t] = min{ F[c - 1][t - coins[i]] + 1, F[c - 1][t] }

    ---

    0-n:

    F[c][t] = min{ F[c][t - coins[i]] + 1, F[c - 1][t] }

    for c:
        for t:
    F[t] = min{ F[t - coins[c]] + 1, F[t] }

     */
    public int coinChange(int[] coins, int amount) {
        int[] a = new int[amount + 1];
        a[0] = 0;
        for (int i = 1; i <= amount; i++) {
            a[i] = -1;
        }

        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                int r = -1;
                if (i >= coin && a[i - coin] >= 0) {
                    r = a[i - coin] + 1;
                }

                if (a[i] > 0) {
                    if (r > 0 && a[i] < r || r < 0) {
                        r = a[i];
                    }
                }

                a[i] = r;
            }
            //System.out.println("coin = " + coin);
            //System.out.println(Arrays.toString(a));
        }
        return a[amount];
    }
}
