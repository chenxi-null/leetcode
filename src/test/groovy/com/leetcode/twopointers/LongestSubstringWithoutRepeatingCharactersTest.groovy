package com.leetcode.twopointers

import spock.lang.Specification

/**
 *
 * @author chenxi20* @date 2021/4/21
 */
class LongestSubstringWithoutRepeatingCharactersTest extends Specification {

    /*
    9:05 上午	info
			解答失败:
			测试用例:"abcabcbb"
			测试结果:4
			期望结果:3
			stdout:

						测试用例:"pwwkew"
						3
     */

    def "LengthOfLongestSubstring"() {
        def t = new LongestSubstringWithoutRepeatingCharacters()
        expect:
        l == t.lengthOfLongestSubstring(s)
        where:
        s            | l
        "abcabcbb"   | 3
        "abcabcabcd" | 4
        ""           | 0
        "a"          | 1
    }
}
