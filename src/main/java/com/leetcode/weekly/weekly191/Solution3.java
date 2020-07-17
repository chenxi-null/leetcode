package com.leetcode.weekly.weekly191;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/31
 */
public class Solution3 {
    public int minReorder(int n, int[][] connections) {
        visited = new boolean[n];

        for (int[] c : connections) {
            adj.compute(c[0], (k, list) -> {
                if (list == null) {
                    list = new LinkedList<>();
                }
                list.add(c[1]);
                return list;
            });
            reversed_adj.compute(c[1], (k, list) -> {
                if (list == null) {
                    list = new LinkedList<>();
                }
                list.add(c[0]);
                return list;
            });
        }
        return dfs(0);
    }

    Map<Integer, List<Integer>> adj = new HashMap<>();
    Map<Integer, List<Integer>> reversed_adj = new HashMap<>();
    boolean[] visited;

    private int dfs(int n) {
        visited[n] = true;
        // n -> x
        List<Integer> l1 = adj.get(n);
        // x -> n
        List<Integer> l2 = reversed_adj.get(n);

        if (isEmpty(l1) && isEmpty(l2)) {
            return 0;
        }

        int cnt = 0;
        if (!isEmpty(l1)) {
            for (Integer i : l1) {
                if (!visited[i]) {
                    cnt++;
                }
            }
        }
        List<Integer> res = new LinkedList<>();
        if (!isEmpty(l1)) res.addAll(l1);
        if (!isEmpty(l2)) res.addAll(l2);
        for (Integer i : res) {
            if (!visited[i]) {
                cnt += dfs(i);
            }
        }
        return cnt;
    }

    private boolean isEmpty(List list) {
        return list == null || list.isEmpty();
    }
}
