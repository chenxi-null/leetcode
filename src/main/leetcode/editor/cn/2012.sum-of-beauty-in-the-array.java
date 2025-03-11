/*
 * @lc app=leetcode.cn id=2012 lang=java
 *
 * [2012] Sum of Beauty in the Array
 */

// @lc code=start
class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] minArray = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i=n-1; i>=0; i--) {
            min = Math.min(min, nums[i]);
            minArray[i] = min;
        }

        int ans = 0;
        int max = nums[0];
        for (int i=1; i <= n-2; i++) {
            if (max < nums[i] && nums[i] < minArray[i+1]) {
                ans += 2;
            } else if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) {
                ans += 1;
            }
            max = Math.max(max, nums[i]);
        }
        return ans;
    }
}
// @lc code=end

