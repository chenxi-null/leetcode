package com.leetcode.array

import spock.lang.Ignore
import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/29
 */
@Ignore
class Solution_34_Test extends Specification {
    def "SearchRange"(int[] a, int t) {
        expect:
        println a
        println new Solution_34().searchRange(a, t)
        where:
        a                   | t
        [5, 7, 7, 8, 8, 10] | 8
    }
}
