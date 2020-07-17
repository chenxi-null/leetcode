package com.leetcode.twopointers;
/*
Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Example 1:
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
Follow up:
What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?

链接：https://leetcode-cn.com/problems/max-consecutive-ones-ii

---
len
lenWithFlip

        1 1 1 0 1 1 0 1 1 1 1
len:    1 2 3 0 1 2 0 1 2 3 4
len_f:  1 2 3 4 5 6 3 4 5 6 7

        1 1 1 0 0 1 1
len:    1 2 3 0 0 1 2
len_f:  1 2 3 4 1 2 3

        0 0 0 0
len:    0 0 0 0
len_f:  1 1 1 1

---

#[Better] DP

#[Other] sliding window

It's must be only one '0' in current interval

 */
class MaxConsecutiveOnesII {

    // sliding window
    public int findMaxConsecutiveOnes(int[] nums) {
        int[] a = nums;
        int ans = 0;
        int l = 0;
        int r = 0;
        int count0 = 0;
        // [l, r) ; always l < r
        while (r < a.length) {
            // right: add a 0
            if (a[r++] == 0) {
                count0++;
            }
            while (count0 > 1) {
                // left: remove a 0
                if (a[l++] == 0) {
                    count0--;
                }
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }

    public int _findMaxConsecutiveOnes(int[] nums) {
        int[] a = nums;
        int n = a.length;

        int ans = 0;
        // the max length of subsequence that ends with current element, without flipping
        int len = 0;
        // the max length of subsequence that ends with current element, with one flipping
        int len_f = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                // 0, 0 or it's first element
                if (i == 0 || a[i - 1] == 0) {
                    len_f = 1;
                }
                // 1, 0
                else {
                    if (len != len_f) {
                        len_f = len + 1;
                    } else {
                        len_f++;
                    }
                }
                len = 0;
            } else {
                len++;
                len_f++;
            }

            ans = Math.max(ans, len_f);
        }
        return ans;
    }
}