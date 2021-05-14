//Given an array of distinct integers nums and a target integer target, return t
//he number of possible combinations that add up to target. 
//
// The answer is guaranteed to fit in a 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3], target = 4
//Output: 7
//Explanation:
//The possible combination ways are:
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//Note that different sequences are counted as different combinations.
// 
//
// Example 2: 
//
// 
//Input: nums = [9], target = 3
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// All the elements of nums are unique. 
// 1 <= target <= 1000 
// 
//
// 
// Follow up: What if negative numbers are allowed in the given array? How does 
//it change the problem? What limitation we need to add to the question to allow n
//egative numbers? 
// Related Topics 动态规划 
// 👍 425 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int s = 1; s <= target; s++) {
           for (int num : nums) {
               if (s - num >= 0) {
                   dp[s] += dp[s - num];
               }
           }
        }
        return dp[target];
    }

    // #[WA]
    public int combinationSum4_20210515(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int s = 1; s <= target; s++) {
                if (s - nums[i] >= 0) {
                    dp[s] = dp[s - nums[i]] + dp[s];
                }
            }
        }
        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
e.g. [1,2] 4
1 1 1 1
1 1 2
1 2 1
2 1 1
2 2

对于每个数字不只有放和不放两种状态，还涉及到放置的不同位置

f(s) = sum{ f(s - nums[i]) }, i -> [0, n)


===
后来发现不是 01 背包问题, sad...

以下是❎错误尝试 (2021-05-15 00:30)
转化为背包问题：
f(i, s): 对于前 i 个数字和为 s 的最多组合数
第 i 个数字放 & 不放
f(i,s) = f(i-1, s-nums[i]) + f(i-1,s)

e.g:
nums[0] = 1
nums[1] = 2

i |  |  |  |  |
  -------------
4 |  |  |  |  |
3 | 1| 1| 3|  |
2 | 1| 2| 2| 3|
1 | 1| 1| 1| 1|
  -------------
    1  2  3  4| s

1,2 -> 4
1 1 1 1
1 1 2
2 2

f(0,0) = 1 // init
f(i,0) = 1
f(0,i) = 0

f(1,1) = f(0,1-1) + f(0,1) = 1 + 0 = 1
f(1,2) = f(0,2-1) + f(0,2) = 1 + 0 = 1
f(1,3) = 1
f(1,4) = 1

f(2,1) = 0 + f(1,1) = 1
f(2,2) = f(1,2-2) + f(1,2) = 1 + 1 = 2
 */

