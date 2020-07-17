package com.leetcode

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/11
 */
class ThreePartsWithEqualSumTest extends Specification {
    @Unroll
    def "CanThreePartsEqualSum"() {
        expect:
        can == new ThreePartsWithEqualSum().canThreePartsEqualSum(list as int[])
        where:
        can   | list
        true  | [0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1]
        false | [0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1]
        true  | [3, 3, 6, 5, -2, 2, 5, 1, -9, 4]
        true  | [10, -10, 10, -10, 10, -10, 10, -10]
    }
}
