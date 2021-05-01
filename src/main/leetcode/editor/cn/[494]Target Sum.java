//You are given an integer array nums and an integer target.
//
// You want to build an expression out of nums by adding one of the symbols '+' 
//and '-' before each integer in nums and then concatenate all the integers. 
//
// 
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 
//and concatenate them to build the expression "+2-1". 
// 
//
// Return the number of different expressions that you can build, which evaluate
//s to target. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be tar
//get 3.
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// Example 2: 
//
// 
//Input: nums = [1], target = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 654 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // f(i,j): 前 i 个数目标和为 j 的组合个数
    // 选择：+num or -num
    // f(i,j) = f(i-1, j-num) + f(i-1, j+num)
    public int findTargetSumWays(int[] a, int target) {
        target = Math.abs(target);

        int n = a.length;
        int[][] dp = new int[n + 1][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[2 * 1000 + 1];
        }
        dp[0][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                int num = a[i - 1];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
                if (j + num <= target) {
                    dp[i][j] += dp[i - 1][j + num];
                }
            }
        }

        return dp[n][target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
