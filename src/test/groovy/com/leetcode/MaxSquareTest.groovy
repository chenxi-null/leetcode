package com.leetcode

import com.leetcode.common.TestUtils
import com.leetcode.dp.MaxSquare
import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/8
 */
class MaxSquareTest extends Specification {
    def "MaximalSquare"() {
        char[][] matrix = TestUtils.listTo2DArray([['0', '1']])
        expect:
        1 == new MaxSquare().maximalSquare(matrix)
    }
}
