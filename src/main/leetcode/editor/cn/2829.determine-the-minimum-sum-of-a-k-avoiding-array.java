/*
 * @lc app=leetcode.cn id=2829 lang=java
 *
 * [2829] Determine the Minimum Sum of a k-avoiding Array
 */

// @lc code=start
class Solution {
    public int minimumSum(int n, int k) {
        int ans = 0;
        for (int x = 1, cnt = 0; cnt < n; x++) {
            // if k is odd,  x >= (k+1)/2
            // if k is even, x > k/2
            if ((k+2)/2 <= x && x < k) {
                continue;
            }
            ans += x;
            ++cnt;
        }
        return ans;
    }
}
// @lc code=end

