package com.leetcode;

/**
 * @author chenxi <=chenxi01@souche.com>
 * @date 2020/3/18
 */
public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] || rec1[0] >= rec2[2]
                || rec1[3] <= rec2[1] || rec1[1] >= rec2[3]);
    }
}
