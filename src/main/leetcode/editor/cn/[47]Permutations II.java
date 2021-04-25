//Given a collection of numbers, nums, that might contain duplicates, return all
// possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 681 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        used = new boolean[n];
        dfs(a, new ArrayList<>(n));
        return ans;
    }

    void dfs(int[] a, List<Integer> list) {
        if (list.size() == a.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        Integer pre = null;
        for (int i = 0; i < a.length; i++) {
            if (!used[i] && (pre == null || pre != a[i])) {
                pre = a[i];
                used[i] = true;
                list.add(a[i]);
                dfs(a, list);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
