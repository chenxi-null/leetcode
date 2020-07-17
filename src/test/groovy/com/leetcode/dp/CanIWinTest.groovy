package com.leetcode.dp

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/4/23
 */
class CanIWinTest extends Specification {
    @Unroll
    def "CanIWin"() {
        expect:
        r == new CanIWin().canIWin(m, n)
        where:
        m  | n  | r
        10 | 40 | false
        4  | 6  | true
        1  | 0  | true
        1  | 1  | true
        1  | 3  | true
        2  | 3  | false
        10 | 11 | false
    }
}
