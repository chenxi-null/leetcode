//Given an array nums of n integers, return an array of all the unique quadruple
//ts [nums[a], nums[b], nums[c], nums[d]] such that: 
//
// 
// 0 <= a, b, c, d < n 
// a, b, c, and d are distinct. 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 哈希表 双指针 
// 👍 837 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] a, int target) {
        if (a == null || a.length < 4) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        int n = a.length;
        Arrays.sort(a);
        for (int k = 0; k < n - 3; k++) {
            if (k > 0 && a[k] == a[k - 1]) continue;
            for (int l = k + 1; l <= n - 2; l++) {
                if (l > k + 1 && a[l] == a[l - 1]) continue;
                int i = l + 1;
                int j = n - 1;
                while (i < j) {
                    int s = a[k] + a[l] + a[i] + a[j];
                    if (s < target) {
                        ++i;
                    } else if (s > target) {
                        --j;
                    } else {
                        if (!(i > l && a[i] == a[i - 1] && j < n - 1 && a[j] == a[j + 1])) {
                            List<Integer> list = new ArrayList<>();
                            list.add(a[k]);
                            list.add(a[l]);
                            list.add(a[i]);
                            list.add(a[j]);
                            ans.add(list);
                        }
                        ++i;
                        --j;
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
