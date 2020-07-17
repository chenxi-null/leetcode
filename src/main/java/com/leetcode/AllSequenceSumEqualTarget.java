package com.leetcode;
/*
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

 

示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 

限制：

1 <= target <= 10^5

https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/6
 */
public class AllSequenceSumEqualTarget {

    /*
    [a, a+1, ..., a+n-1]

    (2a + n - 1) * n / 2 == target

    (2a + n - 1) * n == 2 * target

    (2a + n - 1) == 2 * target / n
    a == (2 * target / n - n + 1) / 2

    constraint: (2 * target / n) must be integer
    constraint: (2 * target / n - n + 1) must be even

    min-n: 2; [a, a+1]
    max-n:
        a >= 1,
        so (2a + n - 1) >= n,
        so (2 * target) >= n^2,
        so n <= SQRT(2 * target)
     */
    public int[][] findContinuousSequence(int target) {
        int maxN = (int) Math.sqrt(2 * target);
        List<int[]> list = new ArrayList<>(maxN);
        for (int n = maxN; n >= 2; n--) {
            if (2 * target % n == 0 && (2 * target / n - n + 1) % 2 == 0) {
                int a = (2 * target / n - n + 1) / 2;
                int[] arr = new int[n];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = a++;
                }
                list.add(arr);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
