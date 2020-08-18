package com.leetcode.weekly.weekly202;

/*
Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.

Example 1:

Input: arr = [2,6,4,1]
Output: false
Explanation: There are no three consecutive odds.
Example 2:

Input: arr = [1,2,34,3,4,5,7,23,12]
Output: true
Explanation: [5,7,23] are three consecutive odds.

Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000

https://leetcode-cn.com/problems/three-consecutive-odds

---

#[Trying]
issue: Out Of Memory

 */
class _1553_Minimum_Number_of_Days_to_Eat_N_Oranges {
    public int minDays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = dp[i - 1];
            if (i % 2 == 0) {
                min = Math.min(min, dp[i/2]);
            }
            if (i % 3 == 0) {
                min = Math.min(min, dp[i/3]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}