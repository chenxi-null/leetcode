package com.leetcode.twopointers

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/23
 */
class MinWindowSubstringTest extends Specification {
    /*
    _  _ _   __ _
    ADOBECODEBANC
    l    r
       l      r
          l     r
     */

    def "MinWindow"() {
        expect:
        String actual = new MinWindowSubstring().minWindow(s, t)
        expected == actual
        where:
        s               | t     || expected
        'aa'            | 'aa'   | 'aa'
        'ADOBECODEBANC' | 'ABC'  | 'BANC'
        'ADOBECODEBANC' | 'ABC-' | ''
    }
}
