/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int[] a = nums;
        int n = a.length;
        int i = n - 1;
        for (; i >= 1; i--) {
            // 3, 5, 4, 3, 3, 2, 1
            if (a[i - 1] < a[i]) {
                break;
            }
        }
        if (i == 0) {
            // 3, 3, 2, 2, 1, 1
            reverse(0, n - 1, a);
            return;
        }
        reverse(i, n - 1, a);
        //    i
        // 3, 1, 2, 3, 3, 4, 4, 5
        int cur = i - 1;
        // find the first element that great than a[cur] & swap them two
        for (int j = i; j < n; j++) {
            if (a[j] > a[cur]) {
                swap(cur, j, a);
                break;
            }
        }
    }

    private void reverse(int left, int right, int[] a) {
        while (left < right) {
            swap(left++, right--, a);
        }
    }

    private void swap(int i, int j, int[] a) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
// @lc code=end

/*
1,2,3 -> 1,3,2

3,4,2,1 -> 4,1,2,3

1,2,4,3 -> 1,3,2,4

3,2,1
1,2,3
    _
6,2,5,4,3,1
6,3,1,2,4,5

        a         b
             | [..desc..]
    ... prev | curr ...

    ... new  | [..asc..]


*/
