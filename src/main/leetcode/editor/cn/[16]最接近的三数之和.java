//Given an array nums of n integers and an integer target, find three integers i
//n nums such that the sum is closest to target. Return the sum of the three integ
//ers. You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] a, int target) {
        int n = a.length;
        int minDiff = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(a);
        for (int k = 0; k < n; k++) {
            int l = 0, r = n - 1;
            while (l < r) {
                if (l == k) {
                    ++l;
                    continue;
                }
                if (r == k) {
                    --r;
                    continue;
                }
                int curr = a[l] + a[r] + a[k];
                if (Math.abs(curr - target) < minDiff) {
                    minDiff = Math.abs(curr - target);
                    ans = curr;
                }
                if (curr < target) {
                    ++l;
                } else if (curr > target) {
                    --r;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
