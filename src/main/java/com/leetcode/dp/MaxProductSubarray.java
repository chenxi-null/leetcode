package com.leetcode.dp;
/*
https://leetcode-cn.com/problems/maximum-product-subarray/

   1 2 3 -1 -2 -3   4  -2
+: 1 2 6  0  2  6  24  48
-: 0 0 0 -1 -2 -6 -24 -48
*/
class MaxProductSubarray {

    // https://leetcode-cn.com/problems/maximum-product-subarray/solution/cheng-ji-zui-da-zi-shu-zu-by-leetcode-solution/
    public int maxProduct(int[] nums) {
        //todo
        return 0;
    }

    public int _maxProduct(int[] nums) {
        int[] a = nums;
        int n = nums.length;
        // positive[i]: the max positive product subarray that ends with a[i]
        int[] positive = new int[n];
        // negative[i]: the min negative product subarray that ends with a[i]
        int[] negative = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                positive[i] = a[i] > 0 ? a[i] : 0;
                negative[i] = a[i] < 0 ? a[i] : 0;
                max = a[i];
                continue;
            } 

            if (a[i] > 0) {
                positive[i] = positive[i - 1] > 0 ? positive[i - 1] * a[i] : a[i];
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] * a[i] : 0;
            } else if (a[i] < 0) {
                positive[i] = (negative[i - 1] < 0) ? negative[i - 1] * a[i] : 0;
                negative[i] = (positive[i - 1] > 0) ? positive[i - 1] * a[i] : a[i];
            }

            max = Math.max(positive[i], max);
        }
        return max;
    }
}