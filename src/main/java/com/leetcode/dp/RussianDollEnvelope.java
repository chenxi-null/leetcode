package com.leetcode.dp;
/*
354. Russian Doll Envelopes
You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Note:
Rotation is not allowed.

Example:

Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/4/29
 */
public class RussianDollEnvelope {

    /*
    [2,1] => [5,4] => [6,7] => [7,8]
    [2,1] => [9,2] => [10,3] => [11,4]

    ---

    [1,1] => [2,4] => [3,5]
    [1,1] => [4,2] => [5,3]

    [1,1] [2,4] [3,5] [4,2] [5,3]

    1, 2, 3, 2, 3
     */

    // O(N*log(N))
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return -Integer.compare(a[1], b[1]);
            }
        });
        //System.out.println(Arrays.deepToString(envelopes));

        int[] nums = Arrays.stream(envelopes).mapToInt(e -> e[1]).toArray();
        //System.out.println(Arrays.toString(nums));
        return lengthOfLIS(nums);
    }

    private int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int r = Arrays.binarySearch(tails, 0, len, num);
            int idx = r >= 0 ? r : -r - 1;
            tails[idx] = num;

            if (idx == len) {
                ++len;
            }
        }
        return len;
    }

    //----------------------------------------------------

    // O(N^2)
    public int _maxEnvelopes(int[][] envelopes) {
        if (envelopes.length <= 1) {
            return envelopes.length;
        }

        Arrays.sort(envelopes, Comparator.comparingInt(e -> e[0]));
        System.out.println(Arrays.deepToString(envelopes));

        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][1] > envelopes[j][1]
                        && envelopes[i][0] > envelopes[j][0]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }
        System.out.println(Arrays.toString(dp));

        int max = -1;
        for (int value : dp) {
            max = Math.max(max, value);
        }
        return max;
    }
}
