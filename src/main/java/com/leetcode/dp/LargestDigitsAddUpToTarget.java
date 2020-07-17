package com.leetcode.dp;
/*
1449. Form Largest Integer With Digits That Add up to Target
Given an array of integers cost and an integer target. Return the maximum integer you can paint under the following rules:

The cost of painting a digit (i+1) is given by cost[i] (0 indexed).
The total cost used must be equal to target.
Integer does not have digits 0.
Since the answer may be too large, return it as string.

If there is no way to paint any integer given the condition, return "0".



Example 1:

Input: cost = [4,3,2,5,6,7,2,5,5], target = 9
Output: "7772"
Explanation:  The cost to paint the digit '7' is 2, and the digit '2' is 3. Then cost("7772") = 2*3+ 3*1 = 9. You could also paint "997", but "7772" is the largest number.
Digit    cost
  1  ->   4
  2  ->   3
  3  ->   2
  4  ->   5
  5  ->   6
  6  ->   7
  7  ->   2
  8  ->   5
  9  ->   5
Example 2:

Input: cost = [7,6,5,5,5,6,8,7,8], target = 12
Output: "85"
Explanation: The cost to paint the digit '8' is 7, and the digit '5' is 5. Then cost("85") = 7 + 5 = 12.
Example 3:

Input: cost = [2,4,6,2,4,6,4,4,4], target = 5
Output: "0"
Explanation: It's not possible to paint any integer with total cost equal to target.
Example 4:

Input: cost = [6,10,15,40,40,40,40,40,40], target = 47
Output: "32211"


Constraints:

cost.length == 9
1 <= cost[i] <= 5000
1 <= target <= 5000
 */

public class LargestDigitsAddUpToTarget {
    /*
    dp[t] = max { candidate }

    candidate =
        10 * dp[t - cost[i]] + (i + 1) | dp[t - cost[i]] != 0
        0                              | dp[t - cost[i]] == 0 && t - cost[i] != 0
        i + 1                          | t - cost[i] == 0

    0 <= i < cost.length

    初始状态:
    dp[0] == 0

    answer is dp[target]
     */
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        dp[0] = "0";
        for (int t = 1; t < target + 1; t++) {
            // dp[t] = max { 10 * dp[t - cost[i]] + (i + 1) }
            String max = "0";
            for (int i = 0; i < cost.length; i++) {
                int c = cost[i];
                String cand;
                if (t - c == 0) {
                    cand = String.valueOf(i + 1);
                } else if (t - c > 0) {
                    //10 * dp[t - c] + c
                    cand = "0".equals(dp[t - c]) ? "0" : dp[t - c] + (i + 1);
                } else {
                    cand = "0";
                }
                max = max(max, cand);
            }
            dp[t] = max;
        }
        return dp[target];
    }

    private String max(String a, String b) {
        if (a.length() > b.length()) {
            return a;
        } else if (a.length() < b.length()) {
            return b;
        } else {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) > b.charAt(i)) {
                    return a;
                } else if (a.charAt(i) < b.charAt(i)) {
                    return b;
                }
            }
            return a;
        }
    }
}

