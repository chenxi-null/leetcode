package com.leetcode.dp

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/4/18
 */
class TriangleTest extends Specification {
    @Unroll
    def "MinimumTotal"() {
        expect:
        r == new Triangle().minimumTotal(triangle)
        where:
        triangle                               | r
        [[-1], [3, 2], [-3, 1, -1]]            | -1
        [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]] | 11
    }
}
