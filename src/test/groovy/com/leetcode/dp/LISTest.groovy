package com.leetcode.dp

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/4/15
 */
class LISTest extends Specification {
    @Unroll
    def "LengthOfLIS"() {
        expect:
        l == new LIS().lengthOfLIS(nums as int[])
        where:
        l | nums
        3 | [1, 2, 3]
        0 | []
        4 | [10, 9, 2, 5, 3, 7, 101, 18]
        1 | [0]
        5 | [1, 2, 8, 9, 3, 4, 5]
    }
}
