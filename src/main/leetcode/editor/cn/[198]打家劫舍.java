//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed, the only constraint stopping you from r
//obbing each of them is that adjacent houses have security system connected and i
//t will automatically contact the police if two adjacent houses were broken into 
//on the same night. 
//
// Given a list of non-negative integers representing the amount of money of eac
//h house, determine the maximum amount of money you can rob tonight without alert
//ing the police. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 
//(money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] a) {
        if (a == null || a.length < 1) {
            return 0;
        }
        int n = a.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = i >= 1 ? Math.max(dp[i - 1][0], dp[i - 1][1]) : 0;
            dp[i][1] = i >= 2 ? Math.max(dp[i - 2][0], dp[i - 2][1]) + a[i] : a[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// #[WA] corner case: array is empty
