package com.leetcode.weekly.weekly191

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/31
 */
class Solution3Test extends Specification {
    def "MinReorder"(int n, int[][] a, int r) {
        expect:
        int actual = new Solution3().minReorder(n, a)
        r == actual
        where:
        n | a                                        | r
        6 | [[0, 1], [1, 3], [2, 3], [4, 0], [4, 5]] | 3
    }
}
