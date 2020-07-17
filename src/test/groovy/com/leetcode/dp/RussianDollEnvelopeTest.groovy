package com.leetcode.dp

import com.leetcode.common.TestUtils
import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/4/29
 */
class RussianDollEnvelopeTest extends Specification {

    def "MaxEnvelopes"() {
        expect:
        def actual = new RussianDollEnvelope().maxEnvelopes(TestUtils.listTo2DArray(e))
        r == actual
        where:
        r | e
        3 | [[5,4],[6,4],[6,7],[2,3]]
        4 | [[4,5],[4,6],[6,7],[2,3],[1,1]]
    }
}
