package com.leetcode.common

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/6
 */
class TestUtils {

    static int[][] listTo2DArray(List<List<Integer>> list) {
        int[][] a = new int[list.size()][]
        for (int i = 0; i < list.size(); i++) {
            int[] row = new int[list[i].size()]
            a[i] = row
            for (int j = 0; j < list[i].size(); j++) {
                a[i][j] = list[i][j]
            }
        }
        return a;
    }
}
