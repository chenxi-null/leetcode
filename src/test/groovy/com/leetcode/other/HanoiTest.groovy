package com.leetcode.other

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/15
 */
class HanoiTest extends Specification {
    def "PrintMoveStep"(int n) {
        expect:
//        new Hanoi().printMoveStep(n)
        println '-----\n'
        where:
        n << [1, 2, 3, 4]
    }
}
