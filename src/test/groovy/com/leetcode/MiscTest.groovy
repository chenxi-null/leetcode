package com.leetcode;

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/4/12
 */
class MiscTest extends Specification {

    def "max number"() {
        expect:
        21_4748_3647 == Integer.MAX_VALUE
        10 == Integer.MAX_VALUE.toString().length()
        922_3372_0368_5477_5807L == Long.MAX_VALUE
        19 == Long.MAX_VALUE.toString().length()
    }

}
