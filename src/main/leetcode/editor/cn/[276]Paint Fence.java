//You are painting a fence of n posts with k different colors. You must paint th
//e posts following these rules: 
//
// 
// Every post must be painted exactly one color. 
// At most one pair of adjacent fence posts can have the same color. 
// 
//
// Given the two integers n and k, return the number of ways you can paint the f
//ence. 
//
// 
// Example 1: 
//
// 
//Input: n = 3, k = 2
//Output: 6
//Explanation: All the possibilities are shown.
//Note that painting all the posts red or all the posts green is invalid because
// there can only be at most one pair of adjacent posts that are the same color.
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: n = 7, k = 2
//Output: 42
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 50 
// 1 <= k <= 105 
// The answer is guaranteed to be in the range [0, 231 - 1] for the given n and 
//k. 
// 
// Related Topics 动态规划 
// 👍 109 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // f(i) = f(i-1) * (k-1) + f(i-2) * (k-1)
    // f(i) = 0
    public int numWays(int n, int k) {
        if (n == 1) return k;
        if (n == 2) return k * k;

        int[] dp = new int[n + 1];
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
