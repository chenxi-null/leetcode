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
    // 选择：当前 num 放入或者不放
    // f(i,j) = f(i-1, j) + f(i-1, j-num)
    // f(0,0) = 1
    public int findTargetSumWays(int[] a, int s) {
        // x + y = sum
        // x - y = s
        // x = (sum + s) / 2;
        int sum = 0;
        for (int x : a) {
            sum += x;
        }
        if ((sum + s) % 2 == 1) return 0;
        int target = (sum + s) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : a) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
