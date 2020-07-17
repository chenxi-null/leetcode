package com.leetcode.misc

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/11
 */
class ReverseWordsInAStringIITest extends Specification {
    def 'ReverseWords'() {
        char[] input_char = input as char[]
        char[] output_char = output as char[]

        when:
        new ReverseWordsInAStringII().reverseWords(input_char)
        then:
        output_char == input_char

        where:
        input                                                                       | output
        ['t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'] | ['b', 'l', 'u', 'e', ' ', 'i', 's', ' ', 's', 'k', 'y', ' ', 't', 'h', 'e']
    }
}
