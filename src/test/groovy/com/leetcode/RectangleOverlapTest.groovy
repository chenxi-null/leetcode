package com.leetcode

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/18
 */
class RectangleOverlapTest extends Specification {
    def "IsRectangleOverlap"() {
        expect:
        r == new RectangleOverlap().isRectangleOverlap(rec1 as int[], rec2 as int[])
        where:
        rec1           | rec2            | r
        [4, 0, 6, 6]   | [-5, -3, 4, 2]  | false
        [0, 0, 1, 1]   | [1, 0, 2, 1]    | false
        [7, 8, 13, 15] | [10, 8, 12, 20] | true
    }
}
