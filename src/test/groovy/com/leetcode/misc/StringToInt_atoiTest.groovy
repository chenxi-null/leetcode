package com.leetcode.misc

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/11
 */
class StringToInt_atoiTest extends Specification {
    def "atoi | #s | #i"(String s, int i) {
        expect:
        def actual = new StringToInt_atoi().myAtoi(s)
        i == actual

        where:
        s                  | i

        // leading zero
        ' 000 '            | 0
        ' -000 '           | 0
        '  00042 '         | 42
        '0002147483648000' | 2147483647

        // Explanation: The first non-whitespace character is '-', which is the minus sign.
        //        Then take as many numerical digits as possible, which gets 42.
        '  -42 '           | -42
        '  +42 '           | 42
        '  42 '            | 42

        // Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
        '4193 with words'  | 4193
        '-4193 111'        | -4193

        // Explanation: The first non-whitespace character is 'w', which is not a numerical
        // digit or a +/- sign. Therefore no valid conversion could be performed.
        'words and 987'    | 0
        ''                 | 0
        null               | 0
        '-'                | 0
        '+'                | 0
        '-abc'             | 0
        '--'               | 0
        '++'               | 0

        // Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
        //        Therefore INT_MIN (−231) is returned.
        '-91283472332'     | -2147483648
        '91283472332'      | 2147483647
        '-2147483649'      | -2147483648
        '2147483648'       | 2147483647
        '-2147483649000'   | -2147483648
        '2147483648000'    | 2147483647
    }
}
