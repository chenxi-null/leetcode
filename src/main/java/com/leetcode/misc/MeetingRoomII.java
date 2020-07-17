package com.leetcode.misc;
/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

https://leetcode-cn.com/problems/meeting-rooms-ii
 */

import java.util.Arrays;

public class MeetingRoomII {

    public int minMeetingRooms(int[][] intervals) {
        if (null == intervals || intervals.length == 0) {
            return 0;
        } else if (intervals.length == 1) {
            return 1;
        }

        int n = intervals.length;
        int[] up = Arrays.stream(intervals).mapToInt(i -> i[0]).sorted().toArray();
        int[] down = Arrays.stream(intervals).mapToInt(i -> i[1]).sorted().toArray();

        int count = 0;
        int maxCount = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            for (; j < n && down[j] <= up[i]; j++) {
                --count;
            }
            ++count;

            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}