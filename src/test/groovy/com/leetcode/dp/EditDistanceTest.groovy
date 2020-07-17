package com.leetcode.dp

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/3
 */
class EditDistanceTest extends Specification {
    def "MinDistance"() {
        expect:
        r == new EditDistance().minDistance(w1, w2)
        where:
        w1          | w2          || r
        'abcdef'    | 'abcdef'    || 0
        'horse'     | 'ros'       || 3
        'intention' | 'execution' || 5
        'ab'        | 'cdef'      || 4
        'cde'       | 'ab'        || 3
    }
}
