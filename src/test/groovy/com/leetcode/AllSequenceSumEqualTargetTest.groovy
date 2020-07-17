package com.leetcode

import com.leetcode.common.TestUtils
import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/6
 */
class AllSequenceSumEqualTargetTest extends Specification {

    @Unroll
    def "test"() {
        expect:
        int[][] actual = new AllSequenceSumEqualTarget().findContinuousSequence(target)
        int[][] expected = TestUtils.listTo2DArray(res)
        println Arrays.deepToString(actual)
        println Arrays.deepToString(expected)
        expected == actual
        where:
        target | res
        10     | [[1, 2, 3, 4]]
        9      | [[2, 3, 4], [4, 5]]
        15     | [[1, 2, 3, 4, 5], [4, 5, 6], [7, 8]]
    }
}
