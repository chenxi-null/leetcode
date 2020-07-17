package com.leetcode.array

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/14
 */
class SearchMatrixTest extends Specification {
    /*
    0,0 - 2,3   1 - 12 -> mid == 6

    [[1,3,5,7],
     [10,11,16,20],
     [23,30,34,50]]
     */
    def "SearchMatrix"(int[][] matrix, int target, boolean r) {
        expect:
        r == new SearchMatrix().searchMatrix(matrix, target)
        where:
        matrix                                             | target | r
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]] | 3      | true
    }
}
