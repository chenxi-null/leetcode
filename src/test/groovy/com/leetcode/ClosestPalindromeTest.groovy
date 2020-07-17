package com.leetcode

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/4/12
 */
class ClosestPalindromeTest extends Specification {
    @Unroll
    def "NearestPalindromic"() {
        expect:
        expected == new ClosestPalindrome().nearestPalindromic(n)
        where:
        n        | expected
        // 1 digit
        '9'      | '8'

        // k digit -> k-1 digit or k digit -> k+1 digit
        '1000'   | '999'
        '1001'   | '999'
        '99'     | '101'
        '999'    | '1001'

        // normal
        '1234'   | '1221'

        // self is palindrome
        '131'    | '121'
        '1331'   | '1221'
        '120021' | '119911'

        // the half is changed
        '1283'   | '1331' //[medium + 1]
        '9900'   | '9889' //[medium - 1]
        '12099'  | '12121' //[medium + 1]
        '99900'  | '99899' //[medium - 1]

        '901'    | '898'
        '198'    | '202'

        // big number
        '1112223333332222000' | '1112223333333222111'
    }
}
