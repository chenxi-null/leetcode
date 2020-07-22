package com.leetcode.weekly.weekly198;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/7/19
 */
public class _1518_Water_Bottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int r = 0;
        int n = numBottles;
        int e = 0;
        int k = numExchange;
        while (n > 0 || e >= k) {
            r += n;//drink
            e += n;//remaining empty after drinking

            n = e / k;//change
            e = e % k;//remaining empty after change
        }
        return r;
    }
}
