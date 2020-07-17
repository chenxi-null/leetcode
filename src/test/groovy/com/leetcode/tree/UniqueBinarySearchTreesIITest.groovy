package com.leetcode.tree

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/8
 */
class UniqueBinarySearchTreesIITest extends Specification {
    def "GenerateTrees"() {
        expect:
        List trees = new UniqueBinarySearchTreesII().generateTrees(n)
        println trees.size()
        where:
        n << [0, 1, 2, 3, 4]
    }
}
