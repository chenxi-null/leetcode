/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] a = nums;
        int n = a.length;

        // find the position of a target
        int left = 0;
        int right = n - 1;
        int t_idx = 0;
        boolean found = false;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] < target) {
                left = mid + 1;
            } else if (a[mid] > target) {
                right = mid - 1;
            } else {
                t_idx = mid;
                found = true;
                break;
            }
        }
        if (!found) {
            return new int[]{-1, -1};
        }

        int ans_left = findLeftIndex(left, t_idx, a, target);
        int ans_right = findRightIndex(t_idx, right, a, target);
        return new int[]{ans_left, ans_right};
    }

    // find for left  [.... t]
    private int findLeftIndex(int left, int right, int[] a, int target) {
        while (left < right) {
            if (a[left] == a[right]) {
                return left;
            }
            int mid = (left + right) / 2;
            if (a[mid] == target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // exit condition: left == right
        return left;
    }

    // find for right [t ....]
    private int findRightIndex(int left, int right, int[] a, int target) {
        while (left < right) {
            if (a[left] == a[right]) {
                return right;
            }
            int mid = (left + right) / 2;
            if (a[mid] == target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
// @lc code=end
/*
#[WA] 1. BbinarySearch: `while (left <= right)` not `(left < right)`; 2. low level error: `index > 0` (should be `>= 0`)

#[Better] varietal binary-search

discussion:
https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
 */

/*
class Solution {
    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        // leftmost: [x,t] [t,t]

        // rightmost: [t,x] [t,t]

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
}

//链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-yi-/
 */

