/*
 * @lc app=leetcode.cn id=3355 lang=java
 *
 * [3355] Zero Array Transformation I
 * #Tag/DifferenceArray
 */

// @lc code=start
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] delta = new int[nums.length+1];
        for (int[] q : queries) {
            delta[q[0]]++;
            delta[q[1]+1]--;
        }
        int optCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            optCnt += delta[i];
            if (optCnt < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

