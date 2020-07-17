//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// Design an algorithm to find the maximum profit. You may complete as many tran
//sactions as you like (ie, buy one and sell one share of the stock multiple times
//) with the following restrictions: 
//
// 
// You may not engage in multiple transactions at the same time (ie, you must se
//ll the stock before you buy again). 
// After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 
//day) 
// 
//
// Example: 
//
// 
//Input: [1,2,3,0,2]
//Output: 3 
//Explanation: transactions = [buy, sell, cooldown, buy, sell]
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    dp[i][0] = max{ dp[i-1][0], dp[i-1][1] + p[i] } // max{rest, sell}
    dp[i][1] = max{ dp[i-1][1], dp[i-2][0] - p[i] } // max{rest, buy}
     */
    public int maxProfit(int[] p) {
        if (p == null || p.length <= 1) {
            return 0;
        }
        int[][] dp = new int[p.length][2];
        // corner cases: i == 0; i == 1
        dp[0][0] = 0;
        dp[0][1] = -p[0];
        for (int i = 1; i < p.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + p[i]);

            int tmp = i >= 2 ? dp[i - 2][0] : 0;
            dp[i][1] = Math.max(dp[i - 1][1], tmp - p[i]);
        }
        return dp[p.length - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
    // without DP
    public int maxProfit(int[] a) {
        int n = a.length;
        int ans = 0;
        int l = 0, r = 0;
        for (; r < n; r++) {
            if (r == n - 1) {
                ans += a[r] - a[l];
            } else if (a[r + 1] <= a[r]) {
                if (r + 2 < n && a[r + 2] > a[r + 1]) {
                    if (a[r + 1] >= a[l] && a[r + 2] >= a[r]) {
                        r++;
                    } else if (r == l) {
                        l = r + 1;
                    } else if (a[r] - a[r - 1] < a[r + 2] - a[r + 1]) {
                        ans += a[r - 1] - a[l];
                        l = r + 1;
                    } else {
                        ans += a[r] - a[l];
                        l = r + 2;
                        r++;
                    }
                } else {
                    ans += a[r] - a[l];
                    l = r + 1;
                }
            }
        }
        return ans;
    }
 */
