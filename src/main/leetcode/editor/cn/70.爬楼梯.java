/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    // f{i} = f(i - 1) + f(i - 2)
    public int climbStairs(int n) {
        if (n == 0) return 1;
        int prev = 1;
        int curr = 1;
        for (int i = 2; i<=n; i++) {
            int temp = curr;
            curr = curr + prev; 
            prev = temp;
        }
        return curr;
    }
}
// @lc code=end

