package com.leetcode.tree

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/8
 */
class UniqueBinarySearchTreesTest extends Specification {
    def "NumTrees"() {
        expect:
        r == new UniqueBinarySearchTrees().numTrees(n)
        where:
        r  | n
        0  | 0
        1  | 1
        2  | 2
        5  | 3
        14 | 4
    }
}
