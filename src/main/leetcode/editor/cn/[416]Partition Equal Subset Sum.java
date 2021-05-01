//Given a non-empty array nums containing only positive integers, find if the ar
//ray can be partitioned into two subsets such that the sum of elements in both su
//bsets is equal. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 动态规划 
// 👍 762 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // f(i,j): 对于前 i 个数字，是否存在和为 j 的组合
    // f(i,j) = f(i-1,j-num) || f(i-1,j)
    // f(i,0) = true
    public boolean canPartition(int[] a) {
        int sum = 0;
        for (int x : a) {
            sum += x;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : a) {
            for (int i = target; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i - num] || dp[i];
                }
            }
        }
        return dp[target];
    }

    // f(i,j): 对于前 i 个数字，是否存在 |sum1 - sum2| == j ？
    // j = j0 + num || j0 - num || num - j0
    public boolean canPartition_20210430(int[] a) {
        int n = a.length;
        int maxDiff = n * 100;
        boolean[][] dp = new boolean[n + 1][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new boolean[maxDiff + 1];
        }
        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= maxDiff; j++) {
                int num = a[i - 1];
                dp[i][j] = dp[i - 1][Math.abs(j - num)]
                        || (j + num < maxDiff && dp[i - 1][j + num]);
            }
        }
        return dp[n][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//e.g:
// num == 4
//f(i,5) = f(i-1,1) || f(i-1,9)