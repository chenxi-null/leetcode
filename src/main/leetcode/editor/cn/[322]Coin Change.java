//You are given an integer array coins representing coins of different denominat
//ions and an integer amount representing a total amount of money. 
//
// Return the fewest number of coins that you need to make up that amount. If th
//at amount of money cannot be made up by any combination of the coins, return -1.
// 
//
// You may assume that you have an infinite number of each kind of coin. 
//
// 
// Example 1: 
//
// 
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
// 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: coins = [1], amount = 0
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: coins = [1], amount = 1
//Output: 1
// 
//
// Example 5: 
//
// 
//Input: coins = [1], amount = 2
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2^31 - 1
// 0 <= amount <= 10^4
// 
// Related Topics 动态规划 
// 👍 1242 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // f(i): 凑成 i 的最少硬币数
    // f(i) = min{f(i - coins[k])} + 1
    // f(0) = 0
    public int coinChange(int[] coins, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int c : coins) {
                if (c <= 10000 && i + c <= n && dp[i] != Integer.MAX_VALUE) {
                    dp[i + c] = Math.min(dp[i] + 1, dp[i + c]);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// #[WA] corner case: need consider the range of coins[i]