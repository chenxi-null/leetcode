package com.leetcode

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/9
 */
class MaxSubArrayTest extends Specification {

    @Unroll
    def "MaxSubArray"() {
        expect:
        r == new MaxSubArray().maxSubArray(nums as int[])
        where:
        nums                            | r
        [-2, 1, -3, 4, -1, 2, 1, -5, 4] | 6
        [7, -1, -2, 1]                  | 7
        [-2, -1, -3]                    | -1
    }
}
