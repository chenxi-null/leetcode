/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        bt(0, 0, candidates, target, new LinkedList<>(), ans);
        return ans;
    }

    void bt(int idx, int sum, int[] nums, int target,
            LinkedList<Integer> path, List<List<Integer>> ans) {

        if (sum > target) return;
        else if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i == idx || nums[i] != nums[i - 1]) {
                path.add(nums[i]);
                bt(i + 1, sum + nums[i], nums, target, path, ans);
                path.removeLast();
            }
        }
    }
}
// @lc code=end

/*
#[WA] definition of unique in permutation

same number can come from last level, but can't from current level

---

[1,1,2,3]

---

Testcase
[10,1,2,7,6,1,5]
8

Answer
[[1,2,5],[1,7],[1,6,1],[2,6],[2,1,5],[7,1]]

Expected Answer
[[1,1,6],[1,2,5],[1,7],[2,6]]
 */

