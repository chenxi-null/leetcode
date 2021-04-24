//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//Follow up: If you have figured out the O(n) solution, try coding another solut
//ion using the divide and conquer approach, which is more subtle. Related Topics 
//数组 分治算法 动态规划 
// 👍 3161 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = a[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + a[i], a[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
db[i]: 以 a[i] 结尾的最大子序列

dp[i] = max{dp[i-1] + a[i], a[i]}
 */