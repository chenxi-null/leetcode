package com.leetcode.misc

import spock.lang.Specification

/**
 *
 * @author chenxi20* @date 2021/4/19
 */
class DivideTwoIntegersTest extends Specification {
    /*
    11:40 下午	info
			解答失败:
			测试用例:-2147483648
			-1
			测试结果:-536870913
			期望结果:2147483647
			stdout:
     */

    def "Divide"() {
        def t = new DivideTwoIntegers()
        expect:
        c == t.divide(a, b)
        where:
        a                 | b                 || c
        Integer.MIN_VALUE | -1                || Integer.MAX_VALUE
        Integer.MIN_VALUE | 1                 || Integer.MIN_VALUE


        Integer.MIN_VALUE | Integer.MIN_VALUE || 1
        Integer.MAX_VALUE | Integer.MAX_VALUE || 1
        Integer.MIN_VALUE | Integer.MAX_VALUE || -1
        Integer.MAX_VALUE | Integer.MIN_VALUE || 0

        1                 | 1                 || 1
        1                 | -1                || -1
        10                | 3                  | 3
        9                 | 3                  | 3
        0                 | 1                  | 0
    }
}
