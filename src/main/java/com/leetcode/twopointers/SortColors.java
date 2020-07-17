package com.leetcode.twopointers;
/*
75. Sort Colors
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
 */

public class SortColors {
    /*
    2020/05/19
    public void sortColors(int[] nums) {
        // nums[idx < l] == 0
        int l = 0;
        // nums[l < idx < k] == 1
        int k = 0;
        // nums[idx > r] == 2
        int r = nums.length - 1;
        while (k <= r) {
            if (nums[k] == 0) {
                swap(nums, l++, k++);
            } else if (nums[k] == 2) {
                swap(nums, k, r--);
            } else {
                k++;
            }
        }
    }
     */


    /*
    0,1:
        |         |
    0 0 0 x x x x 1 1 1

          _______
          |     |
    0 0 0 1 x x 0 1 1 1


    0,1,2:
          | |
    0 0 0 0 m m m m

       | |
    1, ... 2

    l ->   <-  r
    0 0 0 1 1 1
        r l
    --------------------

      |     |       |
    0 0 1 1 x ... x 2 2

       l    mid       |
    0 0 x 1 x ... x 2 2

      |     |       |
    0 0 2 1 0 ... x 2 2

        |   |       |
    0 0 0 1 2 ... x 2 2

        |   |       |
    0 0 0 1 2 ... x 2 2
     */
    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }

        // nums[idx < l] == 0
        int l = 0;
        // nums[idx > r] == 2
        int r = nums.length - 1;
        // nums[l < idx < mid] == 1
        int m = 0;
        while (m <= r) {
            if (nums[m] == 0) {
                swap(m, l, nums);
                ++l;
                ++m;
            } else if (nums[m] == 2) {
                swap(m, r, nums);
                --r;
            } else if (nums[m] == 1) {
                ++m;
            }
        }
    }

    private void swap(int i, int j, int[] a) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}