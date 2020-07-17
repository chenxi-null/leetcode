package com.leetcode;

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/2/7
 */
class LinuxPathTest extends Specification {

    @Unroll
    def 'test'() {
        def s = new LinuxPath()
        expect:
        s.simplifyPath(path) == expected
        where:
        path                    | expected
        '/../'                  | '/'
        '/home//foo/'           | '/home/foo'
        '/a/./b/../../c/'       | '/c'
        '/a/../../b/../c//.//'  | '/c'
        '/a//b////c/d//././/..' | '/a/b/c'
        '/...'                  | '/...'
        '.././.a/..b/.c../...'  | '/.a/..b/.c../...'
    }
}
