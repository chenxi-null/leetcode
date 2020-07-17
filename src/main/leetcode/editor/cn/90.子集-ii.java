/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        backtrack(0, nums, new LinkedList<>(), ans);
        return ans;
    }
    
    void backtrack(int idx, int[] a, Deque<Integer> path, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(path));
    
        for (int i = idx; i < a.length; i++) {
            if (i == idx || a[i - 1] != a[i]) {
                path.addLast(a[i]);
                backtrack(i + 1, a, path, ans);
                path.removeLast();
            }
        }
    }
}
// @lc code=end

