/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.nums = candidates;
        this.target = target;
        backtrack(0, 0);
        return ans;
    }

    int[] nums;
    int target;
    LinkedList<Integer> output = new LinkedList<>();
    List<List<Integer>> ans = new LinkedList<>();

    private void backtrack(int idx, int sum) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            ans.add(new ArrayList<>(output));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            output.add(nums[i]);
            backtrack(i, sum + nums[i]);
            output.removeLast();
        }
    }
}
// @lc code=end

