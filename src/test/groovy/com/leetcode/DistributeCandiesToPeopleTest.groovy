package com.leetcode

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/5
 */
class DistributeCandiesToPeopleTest extends Specification {

    @Unroll
    def "test"() {
        expect:
        res as int[] == new DistributeCandiesToPeople().distributeCandies(total, n)
        where:
        total | n || res
        7     | 4 || [1, 2, 3, 1]
        10    | 3 || [5, 2, 3]
        6     | 3 || [1, 2, 3]
        10    | 2 || [4, 6]
        19    | 2 || [9, 10]
        21    | 2 || [9, 12]
    }
}
