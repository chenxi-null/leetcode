package com.leetcode.dp;
/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?

链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 */

import java.util.Arrays;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/4/15
 */
public class LIS {
    // O(N^2)
    public int _lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // tails[i]: 长度为 i+1 的最长子序列的末尾最小的数值
        int[] tails = new int[nums.length];
        int maxIdx = 0;
        tails[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            int insertionIdx = foundInsertionIdx(tails, target, 0, maxIdx);

            if (insertionIdx > maxIdx) {
                maxIdx = insertionIdx;
            }
            tails[insertionIdx] = target;
        }
        return maxIdx + 1;
    }

    private int foundInsertionIdx(int[] a, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (a[mid] < target) {
                low = mid + 1;
            } else if (a[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}
