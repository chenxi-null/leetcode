package com.leetcode.dp;
/*
410. Split Array Largest Sum
Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.

---

Solution:

#dp, #prefix_sum

 */

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/7/25
 */
public class _410_SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        // f(i,j) 表示 前 i 个元素 划分成 j 段后 得到的 minLargestSum
        // f(i,j) = min{ g(i,j,k), j-1 <= k <= i-1 },
        //  g(i,j,k) = max{ f(k,j-1), sum_sub(k+1,i) }
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];

        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            dp[i][1] = presum[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= Math.min(m, i); j++) {
                int min = Integer.MAX_VALUE;
                for (int k = j - 1; k <= i - 1; k++) {
                    int s = presum[i] - presum[k]; // sum of subArray[k + 1, i]
                    min = Math.min(min, Math.max(dp[k][j - 1], s));
                }
                dp[i][j] = min;
            }
        }
        return dp[n][m];
    }
}
