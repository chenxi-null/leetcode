package com.leetcode.sorting

import spock.lang.Specification

/**
 *
 * @author chenxi20* @date 2021/5/5
 */
class QuickSortTest extends Specification {
    def "Sort"() {
        def t = new QuickSort()
        when:
        int[] a = list as int[]
        t.sort(a)
        then:
        isOrder(a)
        where:
        list << [
                [1, 3, 2, 5, 10, 1, 8, 2, 1, 0],
                [1, 1, 1],
                []
        ]
    }

    boolean isOrder(int[] a) {
        if (a == null || a.length <= 1) {
            return true;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }
}
