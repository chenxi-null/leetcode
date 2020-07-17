package com.leetcode.twopointers;
/*
https://leetcode-cn.com/problems/3sum/

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/7
 */
public class ThreeSum {

    /**
     * 如果不能重复使用元素
     */
    public List<List<Integer>> _threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        boolean occurEq = false;
        int i, j;
        int lastI = -1, lastJ = -1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > 0) {
                return res;
            }

            if (!occurEq) {
                if (k > 0 && nums[k] == nums[k - 1]) {
                    continue;
                }
                i = k + 1;
                j = nums.length - 1;
            } else {
                i = lastI;
                j = lastJ;
            }

            occurEq = false;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    --j;
                } else if (sum < 0) {
                    i++;
                } else {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[i + 1]) {
                        ++i;
                    }
                    ++i;
                    while (i < j && nums[j] == nums[j - 1]) {
                        --j;
                    }
                    --j;

                    lastI = i;
                    lastJ = j;
                    occurEq = true;
                    break;
                }
            }
        }
        return res;
    }
}
