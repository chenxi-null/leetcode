/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> ans = new LinkedList<>();
        backtrack(0, nums, used, new LinkedList<>(), ans);
        return ans;
    }

    private void backtrack(int n, int[] nums, boolean[] used,
                           LinkedList<Integer> output, List<List<Integer>> ans) {

        if (n == nums.length) {
            ans.add(new ArrayList<>(output));
        }
        Set<Integer> searched = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!used[i] && !searched.contains(num)) {
                searched.add(num);
                used[i] = true;
                output.add(num);
                backtrack(n + 1, nums, used, output, ans);
                used[i] = false;
                output.removeLast();
            }
        }
    }
}
/*
_     .
1, 1, 1

   _  .
1, 1, 1

   _  .
0, 1, 1

 */

// @lc code=end

