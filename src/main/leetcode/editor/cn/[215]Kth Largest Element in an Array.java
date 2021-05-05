//Given an integer array nums and an integer k, return the kth largest element i
//n the array. 
//
// Note that it is the kth largest element in the sorted order, not the kth dist
//inct element. 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 堆 分治算法 
// 👍 1058 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] a, int k) {
        int n = a.length;
        return quickSort(a, 0, n - 1, n - k);
    }

    private Random random = new Random();

    private int quickSort(int[] a, int start, int end, int kth) {
        if (start > end) {
            throw new IllegalStateException();
        }
        if (start == end) {
            return a[start];
        }

        int mid = partition(a, start, end);
        if (mid < kth) {
            return quickSort(a, mid + 1, end, kth);
        } else if (mid > kth) {
            return quickSort(a, start, mid - 1, kth);
        } else {
            return a[kth];
        }
    }

    private int partition(int[] a, int start, int end) {
        int idx = random.nextInt(end - start + 1) + start;
        swap(a, start, idx);
        int pivot = a[start];
        int left = start + 1, right = end;
        while (left < right) {
            while (left < right && a[left] <= pivot) ++left;
            while (left < right && a[right] >= pivot) --right;
            if (left < right) {
                swap(a, left, right);
                ++left;
                --right;
            }
        }
        if (left == right && a[right] > pivot) {
            --right;
        }
        swap(a, start, right);
        return right;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
