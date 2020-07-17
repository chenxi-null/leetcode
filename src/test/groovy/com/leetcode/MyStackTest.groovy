package com.leetcode

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/1
 */
class MyStackTest extends Specification {

    def "Name"() {
        def s = new MyStack()
        expect:
        s.push(1)
        s.push(2)
        s.push(3)
        s.top() == 3
        s.pop() == 3
        s.top() == 2
        s.pop() == 2
        s.top() == 1
        s.pop() == 1
        s.empty()
    }

    def "test"() {
        def s = new MyStack()
        expect:
        s.empty()
        s.push(1)
        s.push(2)
        s.top() == 2
        s.pop()
        s.top() == 1
        !s.empty()
        s.pop()
        s.empty()

        s.push(1)
        s.push(2)
        s.push(3)
        s.top() == 3
    }
}
