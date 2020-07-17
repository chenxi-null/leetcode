package com.leetcode

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/4/17
 */
class BinarySearchTest extends Specification {
    @Unroll
    def "SearchInsert"() {
        expect:
        r == new BinarySearch().searchInsert(nums as int[], target)
        where:
        nums         | target | r
        [1, 3]       | 0      | 0
        [1, 3]       | 2      | 1
        [1, 3]       | 4      | 2
        [1, 3]       | 1      | 0
        [1, 3]       | 3      | 1
        [1, 3, 5, 6] | 5      | 2
        [1, 3, 5, 6] | 2      | 1
        [1, 3, 5, 6] | 7      | 4
        [1, 3, 5, 6] | 0      | 0
    }
}
