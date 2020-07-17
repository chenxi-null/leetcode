package com.leetcode;
/*
Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])

 
Example 1:

Input: A = [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
Example 2:

Input: A = [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false
Example 3:

Input: A = [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 

Constraints:

3 <= A.length <= 50000
-10^4 <= A[i] <= 10^4

https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 */

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/11
 */
public class ThreePartsWithEqualSum {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        if (sum % 3 != 0) {
            return false;
        }

        int s = 0;
        int thirdSum = sum / 3;

        int i;
        for (i = 0; i < A.length - 2; i++) {
            s += A[i];
            if (s == thirdSum) {
                break;
            }
        }
        if (i >= A.length - 2) {
            return false;
        }

        s = 0;
        int j;
        for (j = i + 1; j < A.length - 1; j++) {
            s += A[j];
            if (s == thirdSum) {
                break;
            }
        }
        return j < A.length - 1;
    }
}
