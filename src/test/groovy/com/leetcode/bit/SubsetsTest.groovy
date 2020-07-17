package com.leetcode.bit

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/10
 */
class SubsetsTest extends Specification {
    def "Subsets"() {
        def l = new Subsets().subsets([1, 2, 3] as int[])
        String str = l.toString()
        expect:
        '[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]' == str
    }
}
