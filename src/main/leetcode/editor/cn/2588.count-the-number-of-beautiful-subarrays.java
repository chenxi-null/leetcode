/*
 * @lc app=leetcode.cn id=2588 lang=java
 *
 * [2588] Count the Number of Beautiful Subarrays
 * #Tag/PrefixSum
 * #Tag/Map
 * #Tag/BitManipultion
 * 
 * [Template] Use PrefixSum and Map to count the number of subarray.
 */

// @lc code=start
class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        counter.put(0, 1);
        long ans = 0;
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix ^= nums[i];
            Integer cnt = counter.get(prefix);
            if (cnt != null) {
                ans += cnt;
            }
            counter.put(prefix, counter.getOrDefault(prefix, 0) + 1);
        }
        return ans;
    }
}
// @lc code=end
