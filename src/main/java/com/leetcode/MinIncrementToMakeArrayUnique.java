package com.leetcode;
/*
Example 1:

Input: [1,2,2]
Output: 1
Explanation:  After 1 move, the array could be [1, 2, 3].
Example 2:

Input: [3,2,1,2,1,7]
Output: 6
Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.

https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/25
 */
public class MinIncrementToMakeArrayUnique {

    public int minIncrementForUnique(int[] A) {
        int sum = 0;
        Queue<Integer> q = new ArrayDeque<>();
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            int e = A[i];
            if (i != 0 && e == A[i - 1]) {
                q.add(e);
            }
            int curr = e;
            while (i < A.length - 1 && curr < A[i + 1] - 1
                    || i == A.length - 1) {
                if (q.isEmpty()) {
                    break;
                }
                sum += curr + 1 - q.remove();
                ++curr;
            }
        }
        return sum;
    }
}
