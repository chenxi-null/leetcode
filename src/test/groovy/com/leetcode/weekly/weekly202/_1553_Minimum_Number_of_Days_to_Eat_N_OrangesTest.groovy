package com.leetcode.weekly.weekly202


import spock.lang.Specification
import spock.lang.Unroll
/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/8/18
 */
class _1553_Minimum_Number_of_Days_to_Eat_N_OrangesTest extends Specification {

    @Unroll
    def "MinDays: #n -> #r"() {
        expect:
        int actual = new _1553_Minimum_Number_of_Days_to_Eat_N_Oranges().minDays(n)
        r == actual
        where:
        n   | r
        1   | 1
        2   | 2
        3   | 2
        4   | 3
        5   | 4
        9   | 3
        10  | 4
        15  | 5
        30  | 5
        45  | 6
        182 | 8
    }
}
