package com.leetcode.array

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/14
 */
class MergeTwoSortedArrayTest extends Specification {
    def "Merge"(int[] a1, int m, int[] a2, int n) {
        expect:
        new MergeTwoSortedArray().merge(a1, m, a2, n)
        println Arrays.toString(a1)
        where:
        a1                 | m | a2        | n
        [1, 2, 3, 0, 0, 0] | 3 | [2, 5, 6] | 3
    }
}
