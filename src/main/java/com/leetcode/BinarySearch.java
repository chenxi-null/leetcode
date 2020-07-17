package com.leetcode;
/*
https://leetcode-cn.com/problems/search-insert-position/
 */

class BinarySearch {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            // a[right], target, a[left]
            if (left > right) {
                return left;
            }

            int half = left + (right - left) / 2;
            if (target < nums[half]) {
                right = half - 1;
            } else if (target > nums[half]) {
                left = half + 1;
            } else {
                return half;
            }
        }
    }
}