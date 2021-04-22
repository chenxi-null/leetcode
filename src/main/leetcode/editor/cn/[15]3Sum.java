//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k
//]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3264 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        int n = a.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(a);
        int k, i, j;
        for (k = 0; k < n; k++) {
            //k duplicated
            if (k > 0 && a[k] == a[k-1]) {
                continue;
            }
            i = k + 1;
            j = n - 1;
            while (i < j) {
                if (a[i] + a[j] > -a[k]) {
                    --j;
                } else if (a[i] + a[j] < -a[k]) {
                    ++i;
                } else {
                    if ((i == k + 1 || a[i] != a[i - 1]) && (j == n - 1 || a[j] != a[j + 1])) {
                        ans.add(Arrays.asList(a[k], a[i], a[j]));
                    }
                    --j;
                    ++i;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
k, i, j

-5 1, 2, 3, 4

[-1,0,1,2,-1,-4]

[-4, -1, -1, 0, 1, 2]
 */