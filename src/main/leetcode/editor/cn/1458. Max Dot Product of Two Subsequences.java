class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int minVal = -1000 * 1000 - 1;
        for (int i = 0; i <= m; i++) {
            dp[i][0] = minVal;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = minVal;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int p = nums1[i - 1] * nums2[j - 1];
                dp[i][j] = Math.max(
                        Math.max(dp[i - 1][j - 1] + p, p),
                        Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[m][n];
    }
}
/*
// the max dot product between subarray1 (ends with i-th number in nums1)
//  and subarray2 (ends with j-th number in nums2)
 */