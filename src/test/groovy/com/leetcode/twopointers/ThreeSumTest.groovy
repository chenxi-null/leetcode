package com.leetcode.twopointers

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/7
 */
class ThreeSumTest extends Specification {
    /*
    Given array nums = [-1, 0, 1, 2, -1, -4],

    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]

    ---

    [-4, -1, -1, 0, 1, 2]
    [-4, -2, -1, 5, 6]
     */

    def "ThreeSum"() {
        expect:
        println new ThreeSum().threeSum(nums as int[])
        where:
        nums                  | r
        [-1, 0, 1, 2, -1, -4] | null
        [-1, 0, 1, 2, -4]     | null
        [-4, -2, -1, 5, 6]    | null
        [-4, -4, -4, -2, -1, 5, 6]    | null
    }
}
