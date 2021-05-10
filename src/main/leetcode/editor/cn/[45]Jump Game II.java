//Given an array of non-negative integers nums, you are initially positioned at 
//the first index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Your goal is to reach the last index in the minimum number of jumps. 
//
// You can assume that you can always reach the last index. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 
//step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,0,1,4]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 959 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int maxReach = 0;
        int nextMaxReach = 0;
        int jump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxReach >= nums.length - 1) {
                break;
            }
            nextMaxReach = Math.max(nextMaxReach, i + nums[i]);
            if (i == maxReach) {
                ++jump;
                maxReach = nextMaxReach;
            }
        }
        return jump;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*


init state:

m  nm
----
   m
----

=====

corner case:
   m
----
   -----

==========

   i  m
-------
            nm
   ----------
          ---------


-------
         i  m
   ----------
                  nm
          ---------

-------
   ----------
          ---------
 */
