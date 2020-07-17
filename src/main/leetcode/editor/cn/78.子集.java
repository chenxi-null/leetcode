/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        backtrack(0, -1, nums, new boolean[nums.length], new LinkedList<>(), ans);
        return ans;
    }

    void backtrack(int lvl, int lastIdx,
                   int[] nums, boolean[] used,
                   Deque<Integer> path, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(path));
        
        if (lvl == nums.length) {
            return;
        }

        for (int i = lastIdx + 1; i < nums.length; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                backtrack(lvl + 1, i, nums, used, path, ans);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
// @lc code=end

