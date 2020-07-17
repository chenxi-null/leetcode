/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] a = nums;
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int pivotIdx = partition(a, left, right);
            int t = n - pivotIdx;
            if (t > k) {
                left = pivotIdx + 1;
            } else if (t < k) {
                right = pivotIdx - 1;
            } else {
                return a[pivotIdx];
            }
        }
        return a[left];
    }

    private int partition(int[] a, int left, int right) {
        int len = right - left + 1;
        int randIdx = left + new Random().nextInt(len);
        int startIdx = left;
        swap(a, startIdx, randIdx);

        int pivotVal = a[startIdx];
        while (left <= right) {
            if (left <= right && a[left] <= pivotVal) {
                left++;
                continue;
            }
            if (left <= right && a[right] >= pivotVal) {
                right--;
                continue;
            }
            if (left < right) {
                swap(a, left, right);
            }
        }
        swap(a, startIdx, right);
        return right;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
// @lc code=end

/*
#[WA] use a[0] when left and right indexes are used
*/

/*
t   k
l  p       r

0   1
p
[a, b]
t: 1, k: 2
*/
