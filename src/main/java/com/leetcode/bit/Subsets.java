package com.leetcode.bit;
/*
https://leetcode-cn.com/problems/subsets
 */

import java.util.LinkedList;
import java.util.List;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        int maxMask = (int) Math.pow(2, nums.length);
        for (int i = 0; i < maxMask; i++) {
            // generate 0..00 to 1...11
            String bitmask = Integer.toBinaryString(i);

            List<Integer> curr = new LinkedList<>();
            int idx = bitmask.length() - 1;
            for (int num : nums) {
                if (idx >= 0 && bitmask.charAt(idx--) == '1') {
                    curr.add(num);
                }
            }
            res.add(curr);
        }
        return res;
    }
}