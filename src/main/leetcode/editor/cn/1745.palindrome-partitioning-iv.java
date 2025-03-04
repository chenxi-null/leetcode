/*
 * @lc app=leetcode.cn id=1745 lang=java
 *
 * [1745] Palindrome Partitioning IV
 * #Tag/DP
 */

// @lc code=start
class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        // g[i][j] represents if s[i..j] is palindrome
        // g[i][j] = g[i+1][j-1] ^ (s[i]==s[j])
        boolean[][] g = new boolean[n][n]; 
        for (boolean[] a : g) {
            Arrays.fill(a, true);
        }
        for (int i = n-2; i >= 0; --i) {
            for (int j = i+1; j <= n-1; ++j) {
                g[i][j] = g[i+1][j-1] && (s.charAt(i) == s.charAt(j));
            }
        }

        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                if (g[0][i] && g[i+1][j] && g[j+1][n-1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

