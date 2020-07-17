/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
// [[toIdx_i, fromIdx_i] ...]
class Solution {
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
        int count = 0;
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            count++;
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
        return count < n ? new int[]{} :
                res.stream().mapToInt(i -> i).toArray();
    }
}
// @lc code=end

