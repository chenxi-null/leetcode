package com.leetcode.array

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/13
 */
class FindMinimum_in_RotatedSortedArrayTest extends Specification {

    def "FindMin II"(int[] a, int r) {
        expect:
        r == new FindMinimum_in_RotatedSortedArrayII().findMin(a)
        where:
        a                              | r
        [3, 3, 1, 3]                   | 1
        [3, 1, 1]                      | 1

        [1]                            | 1
        [1, 2]                         | 1
        [2, 1]                         | 1
        [1, 2, 3]                      | 1
        [3, 1, 2]                      | 1
        [2, 3, 1]                      | 1
        [3, 4, 5, 1, 2]                | 1
        [4, 5, 6, 7, 0, 1, 2]          | 0

        [1, 1]                         | 1
        [1, 1, 2, 2]                   | 1
        [2, 2, 1, 1]                   | 1
        [1, 1, 2, 2, 3, 3, 3]          | 1
        [3, 3, 1, 1, 2, 2]             | 1
        [2, 2, 3, 3, 1, 1]             | 1
        [3, 3, 4, 4, 5, 5, 1, 1, 2, 2] | 1
    }

    def "FindMin"(int[] a, int r) {
        expect:
        r == new FindMinimum_in_RotatedSortedArray().findMin(a)
        where:
        a                     | r
        [1]                   | 1
        [1, 2]                | 1
        [2, 1]                | 1
        [1, 2, 3]             | 1
        [3, 1, 2]             | 1
        [2, 3, 1]             | 1
        [3, 4, 5, 1, 2]       | 1
        [4, 5, 6, 7, 0, 1, 2] | 0
    }
}
