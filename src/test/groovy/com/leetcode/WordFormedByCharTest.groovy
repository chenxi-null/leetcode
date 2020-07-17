package com.leetcode

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/17
 */
class WordFormedByCharTest extends Specification {
    def 'CountCharacters'() {
        expect:
        sum == new WordFormedByChar0().countCharacters(words as String[], chars)
        sum == new WordFormedByChar().countCharacters(words as String[], chars)

        where:
        words                          | chars            | sum
        ['cat', 'bt', 'hat', 'tree']   | 'atach'          | 6
        ['hello', 'world', 'leetcode'] | 'welldonehoneyr' | 10
    }
}
