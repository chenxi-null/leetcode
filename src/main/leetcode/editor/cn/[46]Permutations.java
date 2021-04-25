//Given an array nums of distinct integers, return all the possible permutations
//. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
// Related Topics 回溯算法 
// 👍 1313 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] a) {
        int n = a.length;
        boolean[] used = new boolean[n];
        dfs(a, used, new ArrayList<>());
        return ans;
    }

    void dfs(int[] a, boolean[] used, List<Integer> list) {
        if (list.size() == a.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(a[i]);
                dfs(a, used, list);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
