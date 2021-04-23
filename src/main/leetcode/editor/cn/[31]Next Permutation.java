//Implement next permutation, which rearranges numbers into the lexicographicall
//y next greater permutation of numbers. 
//
// If such an arrangement is not possible, it must rearrange it as the lowest po
//ssible order (i.e., sorted in ascending order). 
//
// The replacement must be in place and use only constant extra memory. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [1,3,2]
// Example 2: 
// Input: nums = [3,2,1]
//Output: [1,2,3]
// Example 3: 
// Input: nums = [1,1,5]
//Output: [1,5,1]
// Example 4: 
// Input: nums = [1]
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 1073 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] a) {
        int n = a.length;
        if (n <= 1) return;
        // find i
        int i;
        for (i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) break;
        }
        if (i >= 0) { // found i
            // find k
            int k;
            for (k = n - 1; k >= i + 1; k--) {
                if (a[k] > a[i]) break;
            }
            swap(a, i, k);
        }
        // sort: a[i+1 .. n-1]
        int l = i + 1;
        int r = n - 1;
        while (l < r) {
            swap(a, l++, r--);
        }
    }

    void swap(int[] a, int l, int r) {
        int t = a[l];
        a[l] = a[r];
        a[r] = t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*

corner case:
4 3 2 1

---

1 2 3 4
    i j,k
---

7 10 8 6 5
i j  k

find i and j: a[i] < a[j], a[j..end] is descrease

find k: the smallest one that great than a[i] from a[j..end]

swap a[i] a[k]

sort a[j..end]
 */
