/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> ans = new LinkedList<>();
        boolean[] used = new boolean[n];
        backtrack(0, -1, n, k, used, new LinkedList<>(), ans);
        return ans;
    }

    void backtrack(int lvl, int lastIdx,
                   int n, int k, boolean[] used,
                   LinkedList<Integer> path, List<List<Integer>> ans) {
        if (lvl == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = lastIdx + 1; i < n; i++) {
            if (!used[i]) {
                int num = i + 1;
                path.add(num);
                used[i] = true;
                backtrack(lvl + 1, i, n, k, used, path, ans);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
// @lc code=end

