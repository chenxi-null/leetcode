package com.leetcode.twopointers

import com.leetcode.twopointers.SortColors
import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/12
 */
class SortColorsTest extends Specification {
    def "SortColors"(int[] a, Object dummy) {
        expect:
        new SortColors().sortColors(a)
        Arrays.toString(a)
        check(a)
        where:
        a                        | dummy
        [0, 0, 0]                | null
        [1, 1, 1]                | null
        [2, 2, 2]                | null
        [2, 0, 1, 0, 1, 2, 0, 1] | null
    }

    boolean check(int[] a) {
        int[] t = Arrays.copyOf(a, a.length)
        Arrays.sort(t)
        t == a
    }
}
