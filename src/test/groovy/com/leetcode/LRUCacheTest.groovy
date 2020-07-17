package com.leetcode

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/4/27
 */
class LRUCacheTest extends Specification {

    def "test"() {
        LRUCache cache = new LRUCache(2 /* capacity */)

        expect:
        cache.put(1, 1) // 1
        cache.put(2, 2) // 1,2
        cache.get(1) == 1 // 2,1

        cache.put(3, 3) // 1,3 (evicts key 2)
        cache.get(2) == -1 // returns -1 (not found)

        cache.put(4, 4) // 3,4 (evicts key 1)
        cache.get(1) == -1 // returns -1 (not found)
        cache.get(3) == 3 // 4, 3
        cache.get(4) == 4 // 3, 4

        and: "re-insert"
        cache.put(3, 3) // 4, 3 (re-insert)
        cache.put(5, 5) // 3, 5
        cache.get(3) == 3
    }
}
