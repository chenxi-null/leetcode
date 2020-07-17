package com.leetcode.twopointers;

class MaxConsecutiveOnesIII {
    /*
#[share]
    class Solution {
	public int longestOnes(int[] A, int K) {
		int res = 0, i = 0, j = 0;
		for (; i < A.length; i++) {
			if (A[i] == 0) {
				if (K > 0) {
					K--;
				} else {
					res = Math.max(res, i - j);
					while (A[j++] == 1);
				}
			}
		}
		return Math.max(res, i - j);
	}
}

|--k--|
0 ... 0 1
j       i

|--k--|
0 ... 0 1 0
  j       i

链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii/solution/hua-dong-chuang-kou-2ms-jian-ji-by-gao_yuan/
     */

    /*
    MaxConsecutiveOnesIII
     */
    public int longestOnes(int[] A, int K) {
        int[] a = A;
        int n = a.length;
        int k = K;

        int ans = 0;
        int l = 0;
        int r = 0;
        int change = 0;
        // [l, r)
        while (r < n) {
            if (a[r++] == 0) {
                change++;
            }
            while (change > k) {
                if (a[l++] == 0) {
                    change--;
                }
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
    /*
    corner cases:

    k: 0
    [0...0]
    ans: 0

    [1] -> 1

    [0] -> 0

    []

    0.. 1.. 0.. 1.. 0..
     */
}