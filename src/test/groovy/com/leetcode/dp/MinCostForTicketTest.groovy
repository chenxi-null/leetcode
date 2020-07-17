package com.leetcode.dp

import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/7
 */
class MinCostForTicketTest extends Specification {

    def "test"() {
        expect:
        r == new MinCostForTicket().mincostTickets(days as int[], costs as int[])
        where:
        days                                    | costs      | r
        [1, 4, 6, 7, 8, 20]                     | [2, 7, 15] | 11
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31] | [2, 7, 15] | 17
    }
}
