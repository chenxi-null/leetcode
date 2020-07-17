package com.leetcode

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/25
 */
class MinIncrementToMakeArrayUniqueTest extends Specification {
    def "MinIncrementForUnique"() {
        expect:
        s == new MinIncrementToMakeArrayUnique().minIncrementForUnique(a as int[])
        where:
        a                  | s
        [1, 2, 2]          | 1
        [3, 2, 1, 2, 1, 7] | 6
    }
}
