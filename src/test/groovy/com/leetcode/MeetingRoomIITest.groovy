package com.leetcode

import com.leetcode.common.TestUtils
import com.leetcode.misc.MeetingRoomII_heap
import spock.lang.Specification
/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/10
 */
class MeetingRoomIITest extends Specification {
    def "MinMeetingRooms"() {
        expect:
        r == new MeetingRoomII_heap().minMeetingRooms(TestUtils.listTo2DArray(a))
        println "-----\n"
        where:
        r | a
        2 | [[9,10],[4,9],[4,17]]
        2 | [[0, 30], [5, 10], [15, 20]]
        1 | [[7, 10], [2, 4]]
    }
}
