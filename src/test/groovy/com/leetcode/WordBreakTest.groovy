package com.leetcode

import com.leetcode.dp.WordBreak
import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/4/23
 */
class WordBreakTest extends Specification {

    def "workBreak"() {
        expect:
        res == new WordBreak().wordBreak(s, dict)
        where:
        s               | dict                                  || res
        "leetcode"      | ["leet", "code"]                      || true
        "applepenapple" | ["apple", "pen"]                      || true
        "catsandog"     | ["cats", "dog", "sand", "and", "cat"] || false
    }
}
