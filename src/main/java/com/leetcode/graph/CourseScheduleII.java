package com.leetcode.graph;
/*
210. Course Schedule II
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

https://leetcode-cn.com/problems/course-schedule-ii/
 */

/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// @lc code=start
// [[toIdx_i, fromIdx_i] ...]
class CourseScheduleII {
    public static void main(String[] args) {
        new CourseScheduleII().findOrder(2, new int[][]{new int[]{1, 0}});
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[][] a = prerequisites;
        Map<Integer, List<Integer>> edges = new HashMap<>();
        int[] indegrees = new int[n];
        for (int i = 0; i < a.length; i++) {
            int to = a[i][0];
            int from = a[i][1];
            indegrees[to]++;
            edges.compute(from, (k, list) -> {
                if (list == null) {
                    list = new LinkedList<>();
                }
                list.add(to);
                return list;
            });
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            res.add(curr);
            List<Integer> indexes = edges.get(curr);
            if (indexes != null) {
                for (int idx : indexes) {
                    indegrees[idx]--;
                    if (indegrees[idx] == 0) {
                        q.offer(idx);
                    }
                }
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
// @lc code=end

