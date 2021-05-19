//English description is not available for the problem. Please switch to Chinese
//. Related Topics 数学
// 👍 160 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            // for each loop:
            //  dp[i-1] < px * x <= dp[i]
            dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);

            // update pointers for next loop:
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// #[WA]: start index from 0 or 1
/*
e.g
p2 p3 p5 dp
1  1  1  1
2  1  1  2
2  2  1  3
2  2  2  5
 */
