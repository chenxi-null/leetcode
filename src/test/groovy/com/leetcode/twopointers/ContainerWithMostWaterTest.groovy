package com.leetcode.twopointers

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/9
 */
class ContainerWithMostWaterTest extends Specification {
    def "MaxArea"() {
        expect:
        r == new ContainerWithMostWater().maxArea(a as int[])
        where:
        r   | a
        49  | [1, 8, 6, 2, 5, 4, 8, 3, 7]
        400 | [1, 80, 6, 2, 5, 4, 80, 3, 7]
    }
}
