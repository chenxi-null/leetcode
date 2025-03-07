/*
 * @lc app=leetcode.cn id=2597 lang=java
 *
 * [2597] The Number of Beautiful Subsets
 * #Tag/Backtracking
 */

// @lc code=start
class Solution {
    int ans = 0;

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] cnt = new int[1000 + 1];
        backtrace(nums, k, cnt, 0, new LinkedList<>());
        return this.ans - 1;
    }

    void backtrace(int[] nums, int k, int[] cnt, int idx, LinkedList<Integer> list) {
        if (idx >= nums.length) {
            ++ans;
            // System.out.println(list);
            return;
        }
        backtrace(nums, k, cnt, idx+1, list);
        if (nums[idx] - k < 0 || cnt[nums[idx] - k] <= 0) {
            cnt[nums[idx]]++;
            // list.add(nums[idx]);
            backtrace(nums, k, cnt, idx+1, list);
            // list.removeLast();
            cnt[nums[idx]]--;
        }
    }
}
// @lc code=end

