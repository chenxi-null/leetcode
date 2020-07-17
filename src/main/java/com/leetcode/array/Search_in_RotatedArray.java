package com.leetcode.array;

/*
Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1


4,0 1,2 - +
4,7 0,2 + +
4,6 7,2 + -

---
#[WA] check input parameter

 */
class Search_in_RotatedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[left] > nums[mid]) {
                if (nums[mid + 1] <= target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (nums[left] <= target && nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}

