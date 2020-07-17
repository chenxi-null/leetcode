package com.leetcode

import com.leetcode.dp.LongestCommonSubsequence
import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/4/13
 */
class LongestCommonSubsequenceTest extends Specification {

    @Unroll
    def 'test'() {
        expect:
        n == new LongestCommonSubsequence().longestCommonSubsequence(a, b)

        where:
        a       | b     | n
        'abcde' | 'ace' | 3
        'abc'   | 'abc' | 3
        'abc'   | 'def' | 0
        'bl'    | 'yby' | 1
        'pmjghexybyrgzczy'| 'hafcdqbgncrcbihkd' | 4

        /*
        'pmjg_hexy_byrg_zczy'| 'hafc_dqbg_ncrc_bihkd' | 4

        // gbrc
        [
         0, 0, 0, 1(g),
         2(h), 0, 0, 0,
         2(b), 0, 2(r), 1,
         0, 3(c), 0, 0
        ]
        [
        0, 0, 0, 7,
        14, 0, 0, 0,
        12, 0, 10, 7,
        0, 11, 0, 0
        ]

        'ghbrgc'|
        'hafcdqbgncrcbihkd' | 4
         */
    }
}
