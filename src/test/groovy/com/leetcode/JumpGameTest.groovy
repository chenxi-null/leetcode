package com.leetcode

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/2/22
 */
class JumpGameTest extends Specification {

    @Unroll
    def "test"() {
        expect:
        new JumpGame().canJump(nums as int[]) == res
        where:
        nums            | res
        [2, 3, 1, 1, 4] | true
        [3, 2, 1, 0, 4] | false
        [0]             | true
    }
}
