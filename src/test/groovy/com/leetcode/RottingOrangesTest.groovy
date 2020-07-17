package com.leetcode

import com.leetcode.common.TestUtils
import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/4
 */
class RottingOrangesTest extends Specification {

    @Unroll
    def "OrangesRotting"() {
        expect:
        int actual = new RottingOranges().orangesRotting(TestUtils.listTo2DArray(grid))
        expected == actual
        where:
        grid                              | expected
        [[2, 1, 1], [1, 1, 0], [0, 1, 1]] | 4
        [[0, 2]]                          | 0
        [[2, 1, 1], [0, 1, 1], [1, 0, 1]] | -1
    }
}
