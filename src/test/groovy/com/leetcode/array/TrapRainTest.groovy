package com.leetcode.array

import com.leetcode.array.TrapRain
import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/9
 */
class TrapRainTest extends Specification {
    def "Trap"() {
        expect:
        r == new TrapRain().trap(h as int[])
        where:
        r | h
        6 |  [0,1,0,2,1,0,1,3,2,1,2,1]

        0 | [0, 0, 0]
        0 | [0, 1, 0]

        0 | []
        0 | [1]
        0 | [1,2]
    }
}
