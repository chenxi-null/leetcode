//Given an integer array nums, you need to find one continuous subarray that if
//you only sort this subarray in ascending order, then the whole array will be sor
//ted in ascending order.
//
// Return the shortest such subarray and output its length.
//
//
// Example 1:
//
//
//Input: nums = [2,6,4,8,10,9,15]
//Output: 5
//Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the
//whole array sorted in ascending order.
//
//
// Example 2:
//
//
//Input: nums = [1,2,3,4]
//Output: 0
//
//
// Example 3:
//
//
//Input: nums = [1]
//Output: 0
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 104
// -105 <= nums[i] <= 105
//
//
//
//Follow up: Can you solve it in O(n) time complexity? Related Topics 数组
// 👍 542 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] a) {
        int n = a.length;
        if (n == 1) return 0;

        int reversedIdx = 0;
        int i;

        // find the first 'reversed' num
        for (i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                reversedIdx = i;
                break;
            }
        }
        if (i >= n) return 0;
        // find the min num from [reversedIdx, n)
        int min = Integer.MAX_VALUE;
        for (i = reversedIdx; i < n; i++) {
            min = Math.min(min, a[i]);
        }
        // find the left-most
        int leftMostIdx = 0;
        for (i = reversedIdx - 1; i > 0; i--) {
            if (min < a[i] && min >= a[i - 1]) {
                leftMostIdx = i;
                break;
            }
        }

        for (i = n - 2; i >= 0; i--) {
            if (a[i] > a[i + 1]) {
                reversedIdx = i;
                break;
            }
        }
        if (i < 0) return 0;

        int max = Integer.MIN_VALUE;
        for (i = reversedIdx; i >= 0; i--) {
            max = Math.max(max, a[i]);
        }

        int rightMostIdx = n - 1;
        for (i = reversedIdx + 1; i < n - 1; i++) {
            if (max > a[i] && max <= a[i + 1]) {
                rightMostIdx = i;
                break;
            }
        }

        return rightMostIdx - leftMostIdx + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
