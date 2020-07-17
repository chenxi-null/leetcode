package com.leetcode.misc;
/*
https://leetcode-cn.com/problems/xor-queries-of-a-subarray/

#[WA] array index out of bounds

 */

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/22
 */
public class XorQueries {
    /*
                     l       r
    s1 = a ^ b ^ c ^ d ^ e ^ f
    s2 = a ^ b ^ c

    s1 ^ s2 = x ^ a ^ a ^ b ^ b ..
            = x ^ 0 ^ 0
            = x
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        if (arr == null || arr.length < 1 || queries == null) {
            return new int[]{};
        }

        int[] s = new int[arr.length];
        s[0] = arr[0];
        for (int i = 1; i < s.length; i++) {
            s[i] = s[i - 1] ^ arr[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = l > 0 ? s[r] ^ s[l - 1] : s[r];
        }
        return ans;
    }
}
