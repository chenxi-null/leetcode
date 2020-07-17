package com.leetcode

import com.leetcode.dp.BestTimeToBuyAndSellStock
import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/9
 */
class BestTimeToBuyAndSellStockTest extends Specification {

    @Unroll
    def "MaxProfit"() {
        expect:
        r == new BestTimeToBuyAndSellStock().maxProfit(prices as int[])
        where:
        prices             | r
        [7, 1, 5, 3, 6, 4] | 5
        [7, 6, 4, 3, 1]    | 0
    }
}
