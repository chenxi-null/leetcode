package com.leetcode.array;
/*
153. Find Minimum in Rotated Sorted Array
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
 */

public class FindMinimum_in_RotatedSortedArray {
    /*
    another solution: find the pivot point

    not rotated:
    [0,1,2]

    rotated:
         |--->
    [4,5,6,7,0,1,2,3]
             <---|

    if mid > a[0], then pivot is in right

    if mid < a[0], then pivot is in left

    https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/xun-zhao-xuan-zhuan-pai-lie-shu-zu-zhong-de-zui-xi/
     */


    /*
    simplest solution
     */
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }


    /*
         | |   |
    [4,5,6,7,0,1,2]

    - 4,6 7,2
    - 4,0 1,2

    - 4,7 0,2
    - 1,2 3,4
     */
    public int _findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int mid;
        while (true) {
            mid = (l + r) / 2;
            // l always great than r
            int left1 = nums[l];
            int right1 = nums[mid];
            int left2 = nums[mid + 1];
            int right2 = nums[r];

            if (left1 <= right1 && left2 <= right2) {
                return Math.min(left1, left2);
            } else if (left1 <= right1 && left2 > right2) {
                l = mid + 1;
            } else if (left1 > right1 && left2 <= right2) {
                r = mid;
            }
        }
    }
}