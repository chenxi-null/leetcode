package com.leetcode.weekly.weekly191;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/31
 */
public class Solution1 {

    public int maxProduct(int[] nums) {
        int[] a = nums;
        int n = a.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int cand = (a[i] - 1) * (a[j] - 1);
                    ans = Math.max(cand, ans);
                }
            }
        }
        return ans;
    }
}
