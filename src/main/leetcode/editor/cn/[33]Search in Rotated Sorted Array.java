//There is an integer array nums sorted in ascending order (with distinct values
//). 
//
// Prior to being passed to your function, nums is rotated at an unknown pivot i
//ndex k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+
//1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, 
//[0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2]. 
//
// Given the array nums after the rotation and an integer target, return the ind
//ex of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// All values of nums are unique. 
// nums is guaranteed to be rotated at some pivot. 
// -104 <= target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 1354 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] a, int target) {
        int n = a.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            if (r - l <= 1) {
                if (a[l] == target) return l;
                if (a[r] == target) return r;
                return -1;
            }
            int mid = (l + r) / 2;
            int midVal = a[mid];
            if (midVal == target) {
                return mid;
            }
            // l | m, r, right interval is ordered
            if (midVal <= a[r]) {
                // l | m, t, r
                if (midVal < target && target <= a[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            // left interval is ordered
            else {
                // l, t, m | r
                if (a[l] <= target && target < midVal) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/

/*

e.g:
[4,5,6,7,0,1,2]
 0 1 2 3 4 5 6

l, m, r
4  7, 2






=====
2020-05-12

1. rotated e.g. (3, 2)
- mid > left,
    - mid > target, [l, m)
        - // l, t, m, |  r -> [l, m)
        - // l, m, | t, r  -> (m, r] ***

    - mid < target, (m, r]
        - // l, m, t, | r -> (m, r]

- mid < right
    - mid > target, [l, m)
        - // l, | t, m, r -> [l, m)

    - mid < target, (m, r]
        - // l, | m, t, r -> (m, r)
        - // l, t, | m, r -> [l, m) ***

2. nature e.g. (1, 6)

// l, t, m, r
- mid > target, [l, m)

// l, m, t, r
- mid < target, (m, r]

---

corner case:
l, m, r
6, 4, 2

*/
