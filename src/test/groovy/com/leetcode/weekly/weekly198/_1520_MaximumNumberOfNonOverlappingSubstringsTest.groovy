package com.leetcode.weekly.weekly198

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/7/24
 */
class _1520_MaximumNumberOfNonOverlappingSubstringsTest extends Specification {
    def 'MaxNumOfSubstrings'(String s, List<String> res) {
        expect:
        def actual = new _1520_MaximumNumberOfNonOverlappingSubstrings().maxNumOfSubstrings(s)
        res == actual
        where:
        s             | res
        'a'           | ['a']
        'adefaddaccc' | ['e', 'f', 'ccc']
        'abbaccd'     | ['bb', 'cc', 'd']
        'abcabcde'    | ['abcabc', 'd', 'e']
        'abcacde'     | ['b', 'd', 'e']
        'dcadaadcc'   | ['dcadaadcc']
    }
}
