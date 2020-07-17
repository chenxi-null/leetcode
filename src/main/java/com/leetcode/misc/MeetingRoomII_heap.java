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
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII_heap {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int[] e : intervals) {
            int startTime = e[0];
            int endTime = e[1];
            if (!q.isEmpty() && startTime >= q.peek()) {
                q.poll();
            }
            q.add(endTime);
        }
        return q.size();
    }
}
