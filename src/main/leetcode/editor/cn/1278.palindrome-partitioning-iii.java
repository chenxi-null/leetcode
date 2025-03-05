/*
 * @lc app=leetcode.cn id=1278 lang=java
 *
 * [1278] Palindrome Partitioning III
 * #Tag/DP
 */

// @lc code=start
class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        // g[i][j] represents whether s[i..j] is palindrome
        boolean[][] g = new boolean[n][n];
        for (boolean[] a : g) {
            Arrays.fill(a, true);
        }
        for (int i = n; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                g[i][j] = g[i+1][j-1] && (s.charAt(i) == s.charAt(j));
            }
        }

        // dp[i][j] represents the minimal number of s[0..i] that need to be divided to j parts
        // dp[i][j] = min{dp[i'][j-1]} + cost(i'+1, i) | (i' < i)
        int[][] dp = new int[n][k+1];
        for (int[] a : dp) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }  
        for (int i = 0; i < n; i++) {
            if (g[0][i]) {
                dp[i][1] = 0;
            } else {
                dp[i][1] = cost(s, 0, i);
            }
        }
        for (int j = 1; j < k; j++) {
            for (int ii = 0; ii < n-1; ii++) {
                for (int i = ii+1; i < n; i++) {
                    if (dp[ii][j] < Integer.MAX_VALUE) {
                        int cost = cost(s, ii+1, i);
                        dp[i][j+1] = Math.min(dp[i][j+1], dp[ii][j] + cost);
                        // System.out.printf("(%s,%s) = %s -> (%s,%s) = %s | [%s,%s](%s) %s\n", 
                        //    ii,j,dp[ii][j], i,j+1,dp[i][j+1], ii+1,i,s.substring(ii+1,i+1),cost);
                    }
                }
            }
        }
        return dp[n-1][k];
    }

    int cost(String s, int left, int right) {
        int r = 0;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                r++;
            }
            left++;
            right--;
        }
        return r;
    }
}
// @lc code=end

