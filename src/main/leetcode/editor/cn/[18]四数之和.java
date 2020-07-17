//Given an array nums of n integers and an integer target, are there elements a,
// b, c, and d in nums such that a + b + c + d = target? Find all unique quadruple
//ts in the array which gives the sum of target. 
//
// Note: 
//
// The solution set must not contain duplicate quadruplets. 
//
// Example: 
//
// 
//Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] a, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        int n = a.length;
        if (n < 4) return ans;
        Arrays.sort(a);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && a[j] == a[j - 1]) continue;

                int l = j + 1, r = n - 1;
                while (l < r) {
                    if (l > j + 1 && a[l] == a[l - 1]) {
                        ++l;
                        continue;
                    }
                    if (r + 1 < n && a[r] == a[r + 1]) {
                        --r;
                        continue;
                    }
                    int sum = a[i] + a[j] + a[l] + a[r];
                    if (sum < target) {
                        ++l;
                    } else if (sum > target) {
                        --r;
                    } else {
                        ans.add(Arrays.asList(a[i], a[j], a[l], a[r]));
                        ++l;
                        --r;
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
