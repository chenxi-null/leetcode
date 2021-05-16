package com.leetcode.weekly.weekly241.first;

class Solution {
    public int subsetXORSum(int[] a) {
        int ans = 0;
        int n = a.length;
        int max = (1 << n) - 1;
        //System.out.println("max:" + max);
        for (int i = 1; i <= max; i++) {
            int xor = 0;

            int t = i;
            int idx = 0;
            while (t != 0) {
                if (t % 2 > 0) {
                    xor ^= a[idx];
                }
                t /= 2;
                idx++;
            }
            //System.out.println(i + "|" + xor);
            ans += xor;
        }
        return ans;
    }

    // e.g. i: 0, 1,  2,  3
    //         0  1   10  11
    public static void main(String[] args) {
        System.out.println(new Solution().subsetXORSum(new int[]{1}));
        System.out.println("----");
        System.out.println(new Solution().subsetXORSum(new int[]{1,3}));
    }
}