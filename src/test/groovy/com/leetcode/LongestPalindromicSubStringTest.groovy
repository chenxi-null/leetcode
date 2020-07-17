package com.leetcode

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/8
 */
class LongestPalindromicSubStringTest extends Specification {
    def "LongestPalindrome"() {
        expect:
        output == new LongestPalindromicSubString().longestPalindrome(input)
        where:
        input | output
        'bb' | 'bb'
        'babad' | 'bab'
        'cbbd' | 'bb'
    }
}
