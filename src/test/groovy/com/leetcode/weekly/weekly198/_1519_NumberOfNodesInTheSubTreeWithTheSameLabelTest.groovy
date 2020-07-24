package com.leetcode.weekly.weekly198

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/7/24
 */
class _1519_NumberOfNodesInTheSubTreeWithTheSameLabelTest extends Specification {

    def "CountSubTrees"(int n, int[][] edges, String labels, int[] res) {
        int[] actual = new _1519_NumberOfNodesInTheSubTreeWithTheSameLabel().countSubTrees(n, edges, labels)
        expect:
        res == actual
        where:
        n | edges                                            | labels    || res
        7 | [[0, 1], [0, 2], [1, 4], [1, 5], [2, 3], [2, 6]] | "abaedcd" || [2, 1, 1, 1, 1, 1, 1]
    }
}
