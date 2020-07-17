//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro. 
//
// Note: 
//
// The solution set must not contain duplicate triplets. 
//
// Example: 
//
// 
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        int n = a.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 3) {
            return ans;
        }
        Arrays.sort(a);
        for (int k = 0; k < n - 2; k++) {
            if (k > 0 && a[k] == a[k - 1]) continue;
            int l = k + 1, r = n - 1;
            while (l < r) {
                if (l - 1 != k && a[l] == a[l - 1]) {
                    ++l;
                    continue;
                }
                if (r + 1 < n && a[r] == a[r + 1]) {
                    --r;
                    continue;
                }
                int sum = a[l] + a[r] + a[k];
                if (sum < 0) {
                    ++l;
                } else if (sum > 0) {
                    --r;
                } else {
                    ans.add(Arrays.asList(a[k], a[l], a[r]));
                    ++l;
                    --r;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
