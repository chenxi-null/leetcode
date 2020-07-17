/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.visited = new boolean[n];
        this.output = new LinkedList<>();
        backtrack(0, new LinkedList<>());
        return this.output;
    }

    private int n;
    private int[] nums;
    private boolean[] visited;
    private List<List<Integer>> output;

    private void backtrack(int idx, LinkedList<Integer> list) {
        if (idx == n) {
            output.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                backtrack(idx + 1, list);
                visited[i] = false;
                list.removeLast();
            }
        }
    }
}
// @lc code=end

