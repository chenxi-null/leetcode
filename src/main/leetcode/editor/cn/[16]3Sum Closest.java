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
// 👍 759 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] a, int target) {
        int closest = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(a);
        int n = a.length;
        for (int k = 0; k < n; k++) {
            int i = k + 1;
            int j = n - 1;
            while (i < j) {
                int s = a[i] + a[j] + a[k];
                if (Math.abs(s - target) < closest) {
                    closest = Math.abs(s - target);
                    ans = s;
                }
                if (s > target) {
                    --j;
                } else if (s < target) {
                    ++i;
                } else {
                    --j;
                    ++i;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
