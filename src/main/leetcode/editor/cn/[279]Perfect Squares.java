//Given an integer n, return the least number of perfect square numbers that sum
// to n. 
//
// A perfect square is an integer that is the square of an integer; in other wor
//ds, it is the product of some integer with itself. For example, 1, 4, 9, and 16 
//are perfect squares while 3 and 11 are not. 
//
// 
// Example 1: 
//
// 
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
// 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 104 
// 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 855 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>(n);
        int x = 1;
        while (x * x <= n) {
            list.add(x * x);
            x++;
        }
        Integer[] nums = list.toArray(new Integer[] {});

        int[] dp = new int[n + 1];
        int max = n + 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = max + 1;
        }
        dp[0] = 0;
        for (int num : nums) {
            for (int i = 1; i <= n; i++) {
                if (i - num >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
