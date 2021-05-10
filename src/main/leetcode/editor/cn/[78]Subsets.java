//Given an integer array nums of unique elements, return all possible subsets (t
//he power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in a
//ny order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// All the numbers of nums are unique. 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1162 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] a) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = a.length;
        int max = (1 << n) - 1; // 2^n - 1
        for (int i = 0; i <= max; i++) {
            List<Integer> list = new ArrayList<>();
            int x = i;
            int j = 0;
            while (x != 0) {
                if (x % 2 == 1) {
                    list.add(a[j]);
                }
                x /= 2;
                j++;
            }
            ans.add(list);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
000 001 010 011 100

10进制 -> 2进制

[0, 2^n-1]
e.g.
n = 3
000, 001, ... 111

O(2^N * N)
 */
