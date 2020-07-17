package com.leetcode.array;
/*
https://leetcode-cn.com/problems/merge-intervals

#[WA] low level error:
    boolean canMerge = intervals[i - 1][1] >= intervals[i][0];
    boolean canMerge = list.getLast()[1] >= intervals[i][0];

 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

class MergeIntervals {
    /*
    x x x * x x
    [s1,e1] [s2,e2] ... [si,ei] ...

    if can merge
       update last element
    else
        append new element
     */
    public int[][] merge(int[][] intervals) {
        if (null == intervals || intervals.length < 1) {
            return new int[][]{};
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] last = res.getLast();
            boolean canMerge = last[1] >= curr[0];
            if (canMerge) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                res.addLast(curr);
            }
        }
        return res.toArray(new int[][]{});
    }
}
