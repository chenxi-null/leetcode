//There is an integer array nums sorted in non-decreasing order (not necessarily
// with distinct values). 
//
// Before being passed to your function, nums is rotated at an unknown pivot ind
//ex k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1]
//, ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0
//,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,
//2,4,4]. 
//
// Given the array nums after the rotation and an integer target, return true if
// target is in nums, or false if it is not in nums. 
//
// 
// Example 1: 
// Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// Example 2: 
// Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// nums is guaranteed to be rotated at some pivot. 
// -104 <= target <= 104 
// 
//
// 
//Follow up: This problem is the same as Search in Rotated Sorted Array, where n
//ums may contain duplicates. Would this affect the runtime complexity? How and wh
//y? Related Topics 数组 二分查找 
// 👍 432 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean search(int[] a, int target) {
        int n = a.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = (r + l) / 2;
            int midVal = a[m];
            if (midVal == target) {
                return true;
            }
            if (a[l] == midVal && midVal == a[r]) {
                ++l;
                --r;
            }
            // l, | m, r
            else if (midVal <= a[r]) {
                // l, | m, t, r
                if (midVal < target && target <= a[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            // l, m | r
            else {
                // l, t, m | r
                if (a[l] <= target && target < midVal) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*

1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1

l     m       r
[1..1] [1..2..1]

a[l] == a[m] == a[r]

----

l           m       l
1 1 1 1 2 2 3 3 1 1 1

 */
