/*
 * @lc app=leetcode.cn id=2070 lang=java
 *
 * [2070] Most Beautiful Item for Each Query
 * #Tag/BinarySearch
 */

// @lc code=start
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int[] maxBeauty = new int[items.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < items.length; i++) {
            max = Math.max(max, items[i][1]);
            maxBeauty[i] = max;
        }
        
        int[] ans = new int[queries.length];
        int i = 0;
        for (int q : queries) {
            ans[i++] = searchMaxBeauty(items, q, maxBeauty);
        }
        return ans;
    }

    int searchMaxBeauty(int[][] items, int q, int[] maxBeauty) {
        // find the price <= q
        int low = 0, high = items.length-1;
        while (low < high) {
            int mid = (high + low + 1) / 2;
            if (items[mid][0] <= q) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return items[low][0] <= q ? maxBeauty[low] : 0; 
    }
}
// @lc code=end

